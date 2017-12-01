/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author giandimi
 */
public class Phonebook {

    static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/bootcamp";
    
    
    static final String USER ="root";
    static final String PASS ="pass";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn=null;
        Statement stmt=null;
         Statement stmt2=null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database....");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Creating statement...");
        stmt=conn.createStatement();
        
        stmt2=conn.createStatement();
        
        String sql;
        sql="SELECT * FROM members";
        ResultSet rs=stmt.executeQuery(sql);  
        while(rs.next()){
            int phone=rs.getInt("phone");
            String firstname =rs.getString("firstname");
            String lastname= rs.getString("lastname");
             String address= rs.getString("address");
            System.out.print("Phone: "+phone);
            System.out.print(", First name: "+firstname);
             System.out.print(", Last name: "+lastname);
             System.out.println(", Address: "+address);
        }
        
        
        // stmt.executeUpdate("INSERT INTO members(phone, firstname, lastname, address) VALUES('+1123451038', 'Jon', 'Connor', 'North America')");
         Scanner sc = new Scanner(System.in);
         System.out.print("GIVE Last name: ");
        String Lname=sc.nextLine();
          System.out.print("GIVE First name: ");
        String Fname=sc.nextLine();
        rs=stmt.executeQuery("SELECT * FROM members WHERE firstname = '"+Fname+"'AND lastname = '"+Lname+"'");
        while(rs.next()){
            int phone=rs.getInt("phone");
            String firstname =rs.getString("firstname");
            String lastname= rs.getString("lastname");
             String address= rs.getString("address");
            System.out.print("Phone: "+phone);
            System.out.print(", First name: "+firstname);
             System.out.print(", Last name: "+lastname);
             System.out.println(", Address: "+address);
        }
        
        String sqlStatement =
           "update members " +
           "set phone = ? " +
         //  "SettingValue = ?" +
           "where lastname = ?"; 
            PreparedStatement updateQuery  = conn.prepareStatement(sqlStatement);
            updateQuery.setInt(1, +1003332299);
            updateQuery.setString(2,"Geo");
           updateQuery.executeUpdate();
        
        
         sql="SELECT COUNT(*) AS total FROM members";
         rs=stmt.executeQuery(sql);
         rs.next();
         int i= rs.getInt("total");
          System.out.print(i);
          
          
          
  sql = "create table IF NOT EXISTS birthday " +
              "(dateofbirth varchar(32) , " +
              " phone   int(11), " +
              "foreign key(phone) references members (phone))";
     stmt.executeUpdate(sql)  ;
     
     
    
        sql="SELECT * FROM members";
       rs=stmt.executeQuery(sql);  
        while(rs.next()){
            int phone=rs.getInt("phone");
            String firstname =rs.getString("firstname");
            String lastname= rs.getString("lastname");
             String address= rs.getString("address");
            System.out.print("give birthday for user with Phone: "+phone);
            System.out.print(", First name: "+firstname);
             System.out.print(", Last name: "+lastname);
             System.out.println(", Address: "+address);
             String dot=sc.nextLine();
             stmt2.executeUpdate("INSERT INTO birthday(dateofbirth, phone) VALUES('"+dot+"', '"+phone+"')");
        }
     
       
         System.out.print("GIVE birthday ");
        String birth=sc.nextLine();
        sql=" select distinct * from members,birthday where members.phone = birthday.phone and birthday.dateofbirth ='"+birth+"'";
        rs=stmt.executeQuery(sql);  
        while(rs.next()){
            int phone=rs.getInt("phone");
            String firstname =rs.getString("firstname");
            String lastname= rs.getString("lastname");
             String address= rs.getString("address");
            System.out.print("Phone: "+phone);
            System.out.print(", First name: "+firstname);
             System.out.print(", Last name: "+lastname);
             System.out.println(", Address: "+address);
        } 
        
        
        
        
        
        
        rs.close();
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
