/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Login {
    private boolean logsuccess=false;
    private int userid=0;
    public Login(Dbacc db) throws SQLException{
     int tr=3; 
     Scanner sc = new Scanner(System.in);
     String user;
     String pass;
     String sql;
     
     ResultSet rs;
     sql="SELECT id,username,password FROM users";
      rs=db.getResultset(sql);
     while (tr>0){
      System.out.println(" tries left "+tr);
      System.out.println(" enter username ");
      user=sc.nextLine();
      System.out.println(" enter password ");
      pass=sc.nextLine();
      rs.beforeFirst();
      while(rs.next()){
       if(user.equals(rs.getString("username"))&&pass.equals(rs.getString("password"))){
        logsuccess=true;
        userid=rs.getInt("id");
        System.out.println("welcome");
        break;
        }
      
     }
     if (logsuccess) break;
     tr--;
     }
     
 }
    
    
    public boolean getLoginSuccess(){
        return logsuccess;
    }
     public int getGetUserid(){
        return userid;
    }
    
    
}
