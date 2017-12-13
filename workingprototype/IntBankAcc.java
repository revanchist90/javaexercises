/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author giandimi
 */
public class IntBankAcc {
    String[] Users;
    Double[] balance;
    private int uid;
    private Dbacc db;
    private Scanner sc = new Scanner(System.in);
    StringBuffer sbf= new StringBuffer();
    public IntBankAcc(Dbacc db,int uid) throws SQLException{
        String sql;
        this.uid=uid; 
        this.db=db;
        //init arrays
        this.Users = new String[3];
        this.balance=new Double[3];
        ResultSet rs;
        
        sql="SELECT username FROM users";
        rs=db.getResultset(sql);
        for(int i=0; i<3; i++){
            rs.next();
            this.Users[i]=rs.getString("username");
         }
        
        
        sql="SELECT amount FROM accounts";
        rs=db.getResultset(sql);
        for(int i=0; i<3; i++){
            rs.next();
            this.balance[i]=rs.getDouble("amount");
            System.out.println("user :"+this.Users[i]+" has balance: "+this.balance[i]);
         }
        rs.close();
    
    }
    @Override
    public String toString(){
        System.out.println("current user is "+this.Users[this.uid-1]+" and has balance:"+this.balance[this.uid-1]);
        return null;
    }
    
     public void showMembers(){
       for(int i=1; i<3; i++){
         System.out.println("user :"+this.Users[i]+"  has balance:"+this.balance[i]);
       
       }
     
     }
    
     public void adminWithdraws() throws SQLException{
         double withdraw; 
         for(int i=1; i<3; i++){
              System.out.println("how much do you want to withdraw from user "+this.Users[i]);
              withdraw=sc.nextDouble();
              if ((withdraw>this.balance[i])||(withdraw<0)){
                 System.out.println("invalid amount");
              }else{
               this.balance[0]+=withdraw;
               this.balance[i]-=withdraw;
               //update buffer
               
              }
          }
         //update database
         for(int i=0; i<3; i++){
              db.updateBalance(i+1, this.balance[i]);
         }
     }
    
      public void adminDeposits() throws SQLException{
         double deposit; 
         for(int i=1; i<3; i++){
              System.out.println("how much do you want to deposit to user "+this.Users[i]);
              deposit=sc.nextDouble();
              if ((deposit>this.balance[0])||(deposit<0)){
                 System.out.println("invalid amount");
              }else{
               this.balance[0]-=deposit;
               this.balance[i]+=deposit;
               //update buffer
               
              }
          }
          //update database
         for(int i=0; i<3; i++){
              db.updateBalance(i+1, this.balance[i]);
         }
         
     }
    
     public void userDepositsToAdmin(int uid) throws SQLException{
         double deposit; 
         System.out.println("how much do you want to deposit to admin ");
         deposit=sc.nextDouble();
         if ((deposit>this.balance[uid-1])||(deposit<0)){
                 System.out.println("invalid amount");
              }else{
               this.balance[uid-1]-=deposit;
               this.balance[0]+=deposit;
               //update buffer
               db.updateBalance(uid, this.balance[uid-1]);
               db.updateBalance(1, this.balance[0]);
     }
     }
     
      public void userDepositsToUser(int uid) throws SQLException{
         double deposit; 
         
         int ui;
         for(int i=0; i<3; i++){
              System.out.println("type:"+i+"to deposit to user :"+this.Users[i]);
         }
         ui=sc.nextInt();
         if(((ui+1)!=uid)&&(ui>=0)&&(ui<3)){
         System.out.println("how much do you want to deposit to user "+this.Users[ui]);
         deposit=sc.nextDouble();
         if ((deposit>this.balance[uid-1])||(deposit<0)){
                 System.out.println("invalid amount");
              }else{
               this.balance[uid-1]-=deposit;
               this.balance[ui]+=deposit;
              this.sbf.append("user "+this.Users[uid-1]+" deposited "+deposit+"to user"+this.Users[ui]);
              this.sbf.append("\r\n");
               db.updateBalance(uid, this.balance[uid-1]);
               db.updateBalance(ui+1, this.balance[ui]);
             }
          }
    }  
    
      
      public String getCurrentUsername(){
        return this.Users[uid-1];
      
      }
      
      public StringBuffer getSbf(){
        return this.sbf;
      }
      
}
