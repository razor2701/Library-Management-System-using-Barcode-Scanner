package controller;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Necil Dabre, Preet Dabre, Glen Dabre, Chris Carvalho
 */
public class DataBaseConnection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CON_STRING= "jdbc:mysql://localhost:3306/library";
    
    public static Connection getConnection() {
        Connection con = null; 
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(CON_STRING,USERNAME,PASSWORD);
        }
        catch(SQLException e){
            System.err.println(e);
        }
       catch(ClassNotFoundException e){
            
            System.err.println("ClassNotFound");
        }
        return con;
    }
    
}
