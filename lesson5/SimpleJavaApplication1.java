/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author giandimi
 */
public class SimpleJavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String name;
        String lname;
        String fname;
        String dateofbirth;
        String filename;
        int age;
        String[] lines = new String[3];
        int[] dob=new int[3];  
        Scanner sc = new Scanner(System.in);
        System.out.println("give name");
        name = sc.nextLine();
        System.out.println("give last name");
        lname = sc.nextLine();
        System.out.println("give father's name");
        fname = sc.nextLine();
        filename=lname+"."+name+".txt";
        lines[0] = lname +","+ name +","+ fname;
        System.out.println("give date of birth");
        for(int i = 0; i < 3; i++) {
            dob[i] = sc.nextInt();
        }
        dateofbirth =String.format("%d/%d/%d",dob[0],dob[1],dob[2]);
        age = 2017 - dob[2];  
        lines[1] = dateofbirth;
        lines[2] = Integer.toString(age); 
        FileWriter fw = new FileWriter(filename);
	for (int i = 1; i < 4; i++) {
		fw.write("Line "+ i +":" + lines[i-1]);
                fw.append("\r\n");
	}
        fw.close();
    }
}
