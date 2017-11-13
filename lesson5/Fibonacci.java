/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

import java.util.Scanner;

/**
 *
 * @author giandimi
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int n= scan.nextInt();  
        System.out.println(fib(n));
    }
  public static int fib(int n)  {
        if(n == 0)
              return 0;
        else if(n == 1)
              return 1;
        else
              return fib(n - 1) + fib(n - 2);
}  
}
