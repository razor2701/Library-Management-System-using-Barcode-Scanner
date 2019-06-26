package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Necil Dabre, Preet Dabre, Glen Dabre, Chris Carvalho
 */
public class ManageUser {
    
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static String sql = null;
    
    public static ResultSet getMemberInfo(Connection con ,String memberid){
        try {
            int memid = Integer.parseInt(memberid);
            sql = "select * from members where memid = ?";
            ps =con.prepareStatement(sql);
            ps.setInt(1, memid);
            return ps.executeQuery();
        } catch (Exception e) {
            System.out.println(""+e);
        }
        return rs;
    }
    
    public static boolean deleteUser(Connection con ,String memberid){
        try {
             
            int memid = Integer.parseInt(memberid);
            sql = "delete  from members where memid = ?";
            ps =con.prepareStatement(sql);
            ps.setInt(1, memid);
            int i = ps.executeUpdate();
            if(i > 0){
                return true;
            }
            else
                return false;
        } catch (Exception e) {
            System.out.println(""+e);
        }
        return false;
    }
    
    public static boolean insertMember(Connection con,ArrayList data){
        try {
            sql="insert into  members values(?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            int memid = Integer.parseInt((String)data.get(0));
            ps.setInt(1, memid);
            ps.setString(2, (String)data.get(1));
            ps.setString(3, (String)data.get(2));
            ps.setString(4, (String)data.get(3));
            ps.setString(5, (String)data.get(4));
            int i = ps.executeUpdate();
            if(i > 0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            System.out.println(""+e);
        }
        return false;
    }
    
    public static boolean updateMember(Connection con ,ArrayList data){
        try {
            sql="update members set memname = ? , memadd = ? , mememail = ? , password = ?  where memid = ?";
            ps=con.prepareStatement(sql);
            int memid = Integer.parseInt((String)data.get(0));
            ps.setInt(5, memid);
            ps.setString(1, (String)data.get(1));
            ps.setString(2, (String)data.get(2));
            ps.setString(3, (String)data.get(3));
            ps.setString(4, (String)data.get(4));
            int i = ps.executeUpdate();
            if(i > 0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public static boolean isMemIdAvailable(Connection con,String memberid){
        try {
            int memid=Integer.parseInt(memberid);
            sql="select * from members where memid = ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, memid);
            
            rs = ps.executeQuery();
            if(rs.next())
                return false;
            else
                return true;
        }
        catch (Exception e) {
        }
            
        return false;
    }
    
    public static ResultSet searchUser(Connection con,String data){
        try {
            sql="select  memid as ID,memname as name,memadd as Address,mememail as Email,password from members where memid = ? or memname like ? or memadd like ? or mememail like ? or password like ?";
            ps=con.prepareStatement(sql);
            int memid;
            try{
                memid = Integer.parseInt(data);
            }catch(NumberFormatException e){
                memid = 0;
            }
            ps.setInt(1, memid);
            data = "%"+data+"%";
            ps.setString(2,data);
            ps.setString(3,data);
            ps.setString(4,data);
            ps.setString(5,data);
            return ps.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }
    
}
