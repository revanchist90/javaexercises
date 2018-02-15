/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

/**
 *
 * @author giandimi
 */
public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, InterruptedException, IOException {
        Locale.setDefault((new Locale("el", "GR")));
        Menu.ClearCon();
        Login log;
        Dbacc db=new Dbacc();
        db.connect();
        log=new Login(db);
        int uid;
        if(log.getLoginSuccess()){
            uid=log.getGetUserid();
            System.out.println("welcome user with id : "+uid);
            IntBankAcc Inba=new IntBankAcc(db,uid);
            //Inba.toString();
            
            Menu mn=new  Menu(uid,Inba); 
        
        
        
        }else{
            System.out.println("login failed goodbye");
        }
        
        
        db.close();
        
    }
    
}
