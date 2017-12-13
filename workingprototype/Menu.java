/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author giandimi
 */
public class Menu {
    Scanner sc = new Scanner(System.in);
    IntBankAcc inba;
    private int uid;
    public Menu(int uid,IntBankAcc inba) throws InterruptedException, SQLException, IOException{
       this.uid=uid;
        this.inba=inba;
       if (uid==1){
       //admin
       adminMenu();
       }else{
       //user
       userMenu();
       
       }
    
    
    }
    
    
    private void adminMenu() throws InterruptedException, SQLException, IOException{
     int input;
     boolean ex=false;
     while(!ex){
       displayAdminMenu();
       input=sc.nextInt();
       switch (input) {
            case 1:  inba.toString();
                     break;
            case 2:  inba.showMembers();
                     break;
            case 3:  inba.adminDeposits();
                     break;
            case 4:  inba.adminWithdraws();
                     break;
            case 5:  Facc.write(inba.getSbf(),inba.getCurrentUsername());
                     ex=true;
                     break;
            case 6:  ex=true;
                     break;
           
            default:
                    System.out.println("invalid input, pick again");
                    TimeUnit.SECONDS.sleep(3);
                     break;
      }
    }
    
    }
    private void userMenu() throws InterruptedException, SQLException, IOException{
       int input;
       boolean ex=false;
       while(!ex){
         displayUserMenu();
         input=sc.nextInt();
         switch (input) {
            case 1:  inba.toString();
                     break;
            case 2:  inba.userDepositsToAdmin(uid);
                     break;
            case 3:  inba.userDepositsToUser(uid);
                     break;
            case 4: Facc.write(inba.getSbf(),inba.getCurrentUsername());
                     ex=true;
                     break;
            case 5:  ex=true;
                     break;
            default:
                    System.out.println("invalid input, pick again");
                    TimeUnit.SECONDS.sleep(3);
                     break;
        }
        
     }
   }
    public void displayAdminMenu(){
        //clear clear console
        System.out.println("type number(1-6) to do corresponding action");
        System.out.println("1 - View Admin Account");
        System.out.println("2 - View all members accounts");
        System.out.println("3 - Deposit to all Members accounts");
        System.out.println("4 - Withdraw from all members account");
        System.out.println("5 - Send to File Today's Transactions");
        System.out.println("6 - Exit app");
        
    
    }
    
     public void displayUserMenu(){
         //clear console
        System.out.println("type number(1-5) to do corresponding action");
        System.out.println("1 - View your account");
        System.out.println("2 - Deposit to Cooperative Account");
        System.out.println("3 - Deposit to Other Member's Account");
        System.out.println("4 - Send to File Today's Transactions");
        System.out.println("5 - Exit app");
      }
    
    
    
}