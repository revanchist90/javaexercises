/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


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
     sql="SELECT id,username,password FROM users2";
      rs=db.getResultset(sql);
     while (tr>0){
      System.out.println(" tries left "+tr);
      System.out.println(" Enter Username ");
      user=sc.nextLine();
//      System.out.println(" enter password ");
//      pass=sc.nextLine();

        Console cons = null;
        char[] passwd=null;
       // if ((cons = System.console()) != null &&(passwd = cons.readPassword("[%s]", "Password:")) != null);
        cons = System.console();
        passwd = cons.readPassword("[%s]", "Enter Password:");
        pass=new String(passwd);
       



      rs.beforeFirst();
      while(rs.next()){
       if(user.equals(rs.getString("username"))&&(SHA1(pass)).equals(rs.getString("password"))){
        logsuccess=true;
        userid=rs.getInt("id");
        //System.out.println("welcome");
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
    
    
         private static String SHA1(String password)
                {
                    String sha1 = "";

                        MessageDigest crypt = null;
                        try {
                            crypt = MessageDigest.getInstance("SHA-1");
                        } catch (NoSuchAlgorithmException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        crypt.reset();
                        try {
                            crypt.update(password.getBytes("UTF-8"));
                        } catch (UnsupportedEncodingException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        sha1 = byteToHex(crypt.digest());

                    return sha1;
                }

        private static String byteToHex(final byte[] hash)
                {
                    Formatter formatter = new Formatter();
                    for (byte b : hash)
                    {
                        formatter.format("%02x", b);
                    }
                    String result = formatter.toString();
                    formatter.close();
                    return result;
                }
     
     
     
     
     
}
