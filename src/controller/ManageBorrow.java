package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Necil Dabre, Preet Dabre, Glen Dabre, Chris Carvalho
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class ManageBorrow {
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static String sql = null;
    
    public static ResultSet getIssusedBook(Connection con,String bookid){
        try {
            sql="select bid as IssuseId,b.bookid as BookID,b.bookname as BookName,b.edition as edition ,m.memid as memid,m.memname as memname,issusedate,returndate from books_borrowed as bb,books as b,members as m where bb.bookid = b.bookid and m.memid = bb.memid and bb.bookid like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, bookid);
            rs=ps.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }
    public static ResultSet searchBorrower(Connection con,String data){
        ResultSet rs=null;
        
        try {
            sql="SELECT * FROM books_borrowed WHERE bid like ? or bookid like ? or memid like ? or issusedate like ? or returndate like ?";
            ps =  con.prepareStatement(sql);
            ps.setString(1, data);
            ps.setString(2, data);
            ps.setString(3, data);
            ps.setString(4, data);
            ps.setString(5, data);
            
            rs = ps.executeQuery();
            return rs;
            
        } catch (Exception e) {
            System.out.println(""+e);
        }
        return rs;
    }
    
    public static boolean issuseBook(Connection con,ArrayList data){
        try {
            sql = "insert into books_borrowed(bookid,memid,issusedate,returndate) values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,data.get(0).toString());
            ps.setString(2,data.get(1).toString());
            ps.setString(3,data.get(2).toString());
            ps.setString(4,data.get(3).toString());
            
            int i = ps.executeUpdate();
            if(i > 0){
                sql = "update books set avialable= ? where bookid = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1,"No");
            ps.setString(2,data.get(0).toString());
                i = ps.executeUpdate();
                if(i > 0 ){
                    i = ps.executeUpdate();
                    return true;
                }
            }   
        } 
        catch (Exception e) {
            System.out.println(""+e);
            return false;
        }
        return false;
    }
    
    
    public static boolean canBorrow(Connection con,String memid){
        try {
            sql="select count(*) as counter from books_borrowed where memid like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, memid);
            rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt("counter") >=3){
                    return false;
                }
                else
                {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return true;
    }   
    
    public static boolean hasBorrowed(Connection con,String memid){
        try {
            sql="select count(*) as counter from books_borrowed where memid like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, memid);
            rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt("counter") >0){
                    return true;
                }
                else
                {
                    return false;
                }
            }
        } catch (Exception e) {
        }
        return true;
    }
    
    
      public static ResultSet getBorrowerInfo(Connection con,Integer memid){
        ResultSet rs=null;
        try {
            sql="select * from members where memid = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, memid);
            rs = ps.executeQuery();
            return rs;
        }
        catch (Exception e) {
        }
        return rs;
    }
      
      public static boolean returnBook(Connection con,String bookid){
          try {
              sql="delete from books_borrowed where bookid like ?";
              ps = con.prepareStatement(sql);
              ps.setString(1, bookid);
              int i= ps.executeUpdate();
              if(i>0){
                  sql = "update books set avialable = ? where bookid like ?";
                  ps = con.prepareStatement(sql);
                  ps.setString(1, "Yes");
                  ps.setString(2, bookid);
                  i = ps.executeUpdate();
                 if(i>0){
                     return true;
                 }
                 else{
                     return false;
                 }
              }
              else{
                  return false;
              }
          } catch (Exception e) {
              System.out.println(""+e);
          }
          return false;
      }
}
