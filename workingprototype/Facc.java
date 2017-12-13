/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author giandimi
 */
public class Facc {
    

    public static void write(StringBuffer sbf,String username) throws IOException{
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy");
         FileWriter writer = new FileWriter("statement_"+username+"_" + LocalDateTime.now().format(dtf) +".txt");
         writer.write(sbf.toString());
         writer.close();
    }
    
    
}
