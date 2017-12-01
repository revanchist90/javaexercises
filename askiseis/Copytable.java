/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copytable;
import java.sql.*;
/**
 *
 * @author giandimi
 */
public class Copytable {
     static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/bootcamp";
    
    
    static final String USER ="root";
    static final String PASS ="pass";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Connection conn=null;
        Statement stmt=null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database....");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Creating statement...");
        stmt=conn.createStatement();
        String sql ="create table members2 as select * from members";
        stmt.executeUpdate(sql)  ;

   
        stmt.close();
        conn.close();
        
        }catch(SQLException se){
        se.printStackTrace();
        }catch(Exception e){
        e.printStackTrace();
        }finally{
           
            try{
                if(stmt!=null)
                   stmt.close();
            }catch(SQLException se2){}
            try{
                  if(conn!=null)
                     conn.close();
            }catch(SQLException se){
                 se.printStackTrace();
            
            }
        
        }
        
        
     System.out.println("Finished!");
    }
    
}
