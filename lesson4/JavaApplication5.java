/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.util.Scanner;

/**
 *
 * @author giandimi
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner scan= new Scanner(System.in);

    //For string

    String text= scan.nextLine();

    //System.out.println(text);

    //for int

    int num= scan.nextInt();

    //System.out.println(num);
    System.out.println(text+num);
    }
    
}
