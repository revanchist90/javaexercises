/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

/**
 *
 * @author giandimi
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][][]A=new int[3][3][3];
        int[] sumi =new int[3];
        int[] sumj =new int[3];
         int[] sumk =new int[3];
        for(int i=0;i<3;i++){
          for(int j=0;j<3;j++){
             for(int k=0;k<3;k++){
          A[i][j][k]=i+j+k;
          sumi[i]+=A[i][j][k];
          sumj[j]+=A[i][j][k];
          sumk[k]+=A[i][j][k];        
          System.out.println("["+i+"]["+j+"]["+k+"]="+A[i][j][k]);
           
          }
         }
        
        }
          System.out.println(A.length+"   "+A[0].length+"  "+A[0][0].length);
    
    for(int i=0;i<3;i++){
    System.out.println("sum of dimension k for index :"+i+"="+sumk[i]);
     System.out.println("sum of dimension j for index :"+i+"="+sumj[i]);
    System.out.println("sum of dimension i for index :"+i+"="+sumi[i]);
    }
    
    
    }
    
}
