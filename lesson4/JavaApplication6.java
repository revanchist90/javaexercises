/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.util.Scanner;

/**
 *
 * @author giandimi
 */
public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     int a,b,c;
      Scanner scan= new Scanner(System.in);
        do {
      a= scan.nextInt();
      b= scan.nextInt();
      c= scan.nextInt();
     }while(!((b>=3*a)&&c>(a+b)));
        System.out.println("success");
    }
    
}
