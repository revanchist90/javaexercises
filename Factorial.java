/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.util.Scanner;

/**
 *
 * @author giandimi
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n= scan.nextInt();  
        System.out.println(fact(n));
    }
     public static int fact(int n)  {
       if(n==1)
         return 1;
       return fact(n-1) * n;
}  
}
