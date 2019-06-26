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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
public class PopulateCombobox {
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    private static DefaultComboBoxModel model = null;
    
    public static  void setComboBox(Connection con,JComboBox cb,String sql,String colname){
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            model = new DefaultComboBoxModel();
            cb.setModel(model);
            while(rs.next()){
                String data = rs.getString(colname);
                model.addElement(data);
            }
        } 
        catch (Exception e) {
            System.err.print("Error in JComboBox "+e);
        }
        
    }
    
}
