/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author giandimi
 */
public class WriteClass {
    
     public static void write(Person p,FileWriter fw) throws IOException{
         
         String[] lines = new String[3];
         lines[0] = p.getLname() +","+ p.getName() +","+ p.getFname();
         lines[1] = p.getDob();
         lines[2] = Integer.toString(p.getAge()); 
         for (int i = 1; i < 4; i++) {
	       fw.write("Line "+ i +":" + lines[i-1]);
               fw.append("\r\n");
	 }
    }
}
