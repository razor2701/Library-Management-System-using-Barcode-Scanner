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
import java.sql.SQLException;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
public class PopulateTable {
   private static Connection con = null;
   private static ResultSet rs = null;
   private static PreparedStatement ps = null;
    
  
    public static void setTable(JTable table,ResultSet rs){
            table.setModel(DbUtils.resultSetToTableModel(rs));
    }
   public static void setTable(Connection con,JTable table,String sql){
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
            System.err.print("SQL ERROR PopulateTable "+e);
        }
        catch(Exception e){
           System.err.print("Update Table Error "+e);
        }
        
        
    }
}
