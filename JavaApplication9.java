/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

/**
 *
 * @author giandimi
 */
public class JavaApplication9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String[] listofAnimals=new String[]{"cat","dog","pig","bear","bird","parrot","rabbit"};
       for(String animal:listofAnimals){
          if((animal.charAt(0)=='p')){
           System.out.println(animal);
          }    
       }
    } 
    
}
