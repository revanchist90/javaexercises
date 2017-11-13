/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

/**
 *
 * @author giandimi
 */
public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuilder buffer1=new StringBuilder(20);
        StringBuilder buffer2=new StringBuilder("10hel10lo10");
         StringBuilder buffer3=new StringBuilder("hello");
        /* System.out.println(buffer1);
         System.out.println(buffer2);
         System.out.println(buffer3);
         System.out.println(buffer1.toString()+buffer2.toString());
         if(buffer1.toString().equals(buffer3.toString())){
             System.out.println("equals");}*/
         System.out.println(lasti(buffer2,"l"));
         System.out.println(lasti(buffer1,"l"));
         
         
         
    }
    
    public static int lasti( StringBuilder buffer,String s) {
         int index=0;
         int lastindex=-1;
         boolean flag= true; 
         do{
         index=buffer.indexOf(s, index);
         if (index==-1){flag=false;}
         else{lastindex=index;}
         index++;
        // System.out.println(index);
         }while(flag);

     return lastindex; }
    
}
