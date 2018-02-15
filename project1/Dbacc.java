/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giandimi
 */
public class Dbacc {
     static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
     static final String DB_URL="jdbc:mysql://localhost/afdemp_java_1";
     static final String USER ="root";
     static final String PASS ="ag1181990ag!";
     private Connection conn;
     private  Statement stmt;
     private ResultSet rs=null;
     public  void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbacc.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connecting to database....");
        try {
            this.conn=DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (SQLException ex) {
            Logger.getLogger(Dbacc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Creating statement...");
         try {
             stmt=conn.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(Dbacc.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        }
     
     public void close(){
         
         try {
             rs.close();
         } catch (SQLException ex) {
             Logger.getLogger(Dbacc.class.getName()).log(Level.SEVERE, null, ex);
         }
        try {
            this.stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dbacc.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dbacc.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     }
     public ResultSet getResultset(String sql){
         
         try {
             rs=stmt.executeQuery(sql);
         } catch (SQLException ex) {
             Logger.getLogger(Dbacc.class.getName()).log(Level.SEVERE, null, ex);
         }
     
     return rs;
     }
     
//     public void updateBalance(int uid,double bal) throws SQLException{
//          String sqlStatement =
//           "update accounts " +
//           "set amount = ? " +
//         //  "SettingValue = ?" +
//           "where user_id = ?"; 
//            PreparedStatement updateQuery  = conn.prepareStatement(sqlStatement);
//            updateQuery.setDouble(1, bal);
//            updateQuery.setInt(2,uid);
//            updateQuery.executeUpdate();
//            updateQuery.close();
//     
//     }
     
     
     public void updateBalance(int uid,double bal) throws SQLException{
          String sqlStatement =
           "update accounts " +
           "set transaction_date = NOW(),"+       
           "amount = ? " +
         //  "SettingValue = ?" +
           "where user_id = ?"; 
            PreparedStatement updateQuery  = conn.prepareStatement(sqlStatement);
            //updateQuery.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            updateQuery.setDouble(1, bal);
            updateQuery.setInt(2,uid);
            
            updateQuery.executeUpdate();
            updateQuery.close();
     
     }
     
     
}