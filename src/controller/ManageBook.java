package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Necil Dabre, Preet Dabre, Glen Dabre, Chris Carvalho
 */

public class ManageBook {
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static String sql = null;
    
    //genearte the book iD
    public static String generateBookID(Connection con){
        String bookid = "";
        Random r = new Random();
        String number="0123456789";
        do{
            bookid = "";
            for(int i=0;i<13;i++){
                bookid += number.charAt(r.nextInt(10));
            }
        }while(!check(con, bookid));
        return bookid;
    }
    //get the shelf details of a particular shelf id
    public static ResultSet getShelfDetails(Connection con,String shelfid){
        
        try {
            sql="select * from shelf where shelfno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, shelfid);
           
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
        }
        return rs;
    }
    //update Shelf for any changes
    public static boolean updateShelf(Connection con,String shelfid,String location){
            try {
                sql = "update shelf set location = ?  where shelfno = ? ";
                ps = con.prepareStatement(sql);
                System.out.println(""+location);
                ps.setString(1,location);
                ps.setString(2,shelfid);
                if(ps.executeUpdate() > 0){
                    return true;
                }
                else
                {
                    return false;
                }
            } 
            catch (Exception e) {
            }
        return false;
    }
    //check whether the shelf does not contains any book before deleteing the shelf
    public static boolean checkShelfBeforeDelete(Connection con,String shelfid){
        try {
            sql = "select * from books where shelfno like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, shelfid);
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("");
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
    //check whether the Shelf id is already inserted before insertion
    public static boolean checkShelf(Connection con,String shelfid){
          try {
            sql = "Select * from shelf where shelfno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,shelfid);
            rs = ps.executeQuery();
            //if result is generated then Bookid is already inserted
            while(rs.next()){
                return false;
            }
        } catch (Exception e) {
            System.err.printf("Error in Check Book"+e);
            return true;
        }
        return true;
    }
    //check whether the Book id is available
    public static boolean check(Connection con,String bookid){
        try {
            sql = "Select * from books where bookid = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,bookid);
            rs = ps.executeQuery();
            //if result is generated then Bookid is already inserted
            while(rs.next()){
                return false;
            }
        } catch (Exception e) {
            System.err.printf("Error in Check Book"+e);
            return true;
        }
        return true;
    }
    
    public static ResultSet searchBook(Connection con,String data){
        ResultSet rs=null;
        data = "%"+data+"%";
        try {
            sql="SELECT * FROM books WHERE bookid like ? or bookname like ? or isbn like ? or edition like ? or authorname like ? or catid like ? or shelfno like ? or avialable like ?";
            ps =  con.prepareStatement(sql);
            ps.setString(1, data);
            ps.setString(2, data);
            ps.setString(3, data);
            ps.setString(4, data);
            ps.setString(5, data);
            ps.setString(6, data);
            ps.setString(7, data);
            ps.setString(8, data);
            
            rs = ps.executeQuery();
            return rs;
            
        } catch (Exception e) {
            System.out.println(""+e);
        }
        return rs;
    }
    //Insert the Books record( data store in ArrayList) 
    public static boolean insertBook(Connection con,ArrayList data){
        try {
            sql = "insert into books values(?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,data.get(0).toString());
            ps.setString(2,data.get(1).toString());
            ps.setString(3,data.get(2).toString());
            ps.setString(4,data.get(3).toString());
            ps.setString(5,data.get(4).toString());
            ps.setString(6,data.get(5).toString());
            int i = Integer.parseInt((String)data.get(6));
            ps.setInt(7,i);
            ps.setString(8,data.get(7).toString());
            ps.setString(9,data.get(8).toString());
            
            i = ps.executeUpdate();
            if(i > 0){
                return true;
            }
        } 
        catch (Exception e) {
            System.out.println(""+e);
            return false;
        }
        return false;
    }
    // check whether the book is available
    public static boolean isAvaialable(Connection con,String bookid){
        try {
            sql="select * from books where bookid like ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, bookid);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("avialable").toLowerCase().equals("yes")){
                    return true;
                }
                else{
                    return false;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    public static boolean isIssused(Connection con,String bookid){
        try {
                sql = "Select * FROM books_borrowed WHERE bookid = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1,bookid);
                
                rs = ps.executeQuery();
                if(rs.next()){
                    return true;
                }
        } 
        catch (Exception e) {
            return false;
        }
        return false;
    }
    public static boolean delete(Connection con,String bookid){
        try {
                sql = "DELETE FROM books WHERE bookid = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1,bookid);
                
                int i = ps.executeUpdate();
                if(i>0){
                    return true;
                }
        } 
        catch (Exception e) {
            return false;
        }
        return false;
    }
   public static boolean updateBook(Connection con,ArrayList data){
        try {
            sql = "update books set bookname= ? ,isbn = ? ,edition = ? ,authorname = ? ,catid = ? ,nop = ?,shelfno = ? where bookid = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1,data.get(0).toString());
            ps.setString(2,data.get(1).toString());
            ps.setString(3,data.get(2).toString());
            ps.setString(4,data.get(3).toString());
            ps.setString(5,data.get(4).toString());
            int i = Integer.parseInt((String)data.get(5));
            ps.setInt(6,i);
            ps.setString(7,data.get(6).toString());
            ps.setString(8,data.get(7).toString());
            
            i = ps.executeUpdate();
            if(i > 0){
                return true;
            }
        } 
        catch (Exception e) {
            System.out.println(""+e);
            return false;
        }
        return false;
    }
    public static ResultSet getBookInfo(Connection con,String bookid){
        ResultSet rs=null;
        try {
            sql="select * from books where bookid like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, bookid);
            rs = ps.executeQuery();
        }
        catch (Exception e) {
        }
        return rs;
    }
    
    public static boolean insertShelf(Connection con,String shelfno,String location){
        try {
            sql = "insert into shelf values(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, shelfno);
            ps.setString(2,location);
            if(ps.executeUpdate() > 0)
                return true;
            else
                return false;
        } 
        catch (Exception e) {
        }
        return false;
    }
    
    public static boolean deleteShelf(Connection con,String shelfno){
        try {
            sql = "delete from shelf where shelfno like ?";
            
            ps = con.prepareStatement(sql);
            ps.setString(1,shelfno);
            if(ps.executeUpdate() > 0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
}
