/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author giandimi
 */
public class IntBankAcc {
    private String[] Users;
    private Double[] balance;
    private Date[] dates;
    private int uid;
    private Dbacc db;
    private NumberFormat currency=NumberFormat.getCurrencyInstance(new Locale("el", "GR"));
    private Scanner sc = new Scanner(System.in);
  private  StringBuffer sbf= new StringBuffer();
   private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");  
    public IntBankAcc(Dbacc db,int uid) throws SQLException{
        String sql;
        this.uid=uid; 
        this.db=db;
        //init arrays
        this.Users = new String[3];
        this.balance=new Double[3];
        this.dates=new Date[3];
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
            //System.out.println("user :"+this.Users[i]+" has balance: "+this.balance[i]);
         }
        
        sql="select transaction_date from accounts";
        rs=db.getResultset(sql);
        for(int i=0; i<3; i++){
            rs.next();
            this.dates[i]=rs.getTimestamp("transaction_date");
           // System.out.println("user :"+this.Users[i]+" has transaction date: "+sdf.format(this.dates[i]));
         }
        
        rs.close();
    
    }
    @Override
    public String toString(){
        System.out.println("current user is "+this.Users[this.uid-1]+" and has balance:"+NumberFormat.getInstance().format(this.balance[this.uid-1])+",last change:"+sdf.format(this.dates[this.uid-1]));      
        return null;
    }
    
     public void showMembers(){
       for(int i=1; i<3; i++){
         System.out.println("user :"+this.Users[i]+"  has balance:"+NumberFormat.getInstance().format(this.balance[i])+",last change:"+sdf.format(this.dates[i]));
       
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
               this.dates[0]=new Date();
               this.dates[i]=new Date();
               //update buffer
                this.sbf.append(sdf.format(this.dates[0])+":user "+this.Users[0]+" withdrew "+NumberFormat.getInstance().format(withdraw)+" from user "+this.Users[i]);
              this.sbf.append("\r\n");
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
               this.dates[0]=new Date();
               this.dates[i]=new Date();
                this.sbf.append(sdf.format(this.dates[0])+":user "+this.Users[0]+" deposited "+NumberFormat.getInstance().format(deposit)+" to user "+this.Users[i]);
              this.sbf.append("\r\n");
               
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
               this.dates[0]=new Date();
               this.dates[uid-1]=new Date();
                this.sbf.append(sdf.format(this.dates[uid-1])+":user "+this.Users[uid-1]+" deposited "+NumberFormat.getInstance().format(deposit)+" to user "+this.Users[0]);
              this.sbf.append("\r\n");
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
               this.dates[uid-1]=new Date();
               this.dates[ui]=new Date();
              this.sbf.append(sdf.format(this.dates[ui])+":user "+this.Users[uid-1]+" deposited "+NumberFormat.getInstance().format(deposit)+" to user "+this.Users[ui]);
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
