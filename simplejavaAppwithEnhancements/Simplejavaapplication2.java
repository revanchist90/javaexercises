/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author giandimi
 */
public class Simplejavaapplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String[] dateofbirth;
        Person p = new  Person();
        Scanner sc = new Scanner(System.in);
        System.out.println("give name");
        p.setString(1,sc.nextLine()) ;
        System.out.println("give last name");
        p.setString(2,sc.nextLine()) ;
        System.out.println("give father's name");
        p.setString(3,sc.nextLine()) ; 
        System.out.println("give date of birth dd/MM/yyyy");
        p.setString(4,sc.nextLine()) ;
        dateofbirth= p.getDob().split("/");
        p.setString(2017 - Integer.parseInt(dateofbirth[2]));
        FileWriter fw = new FileWriter(p.getLname()+"."+p.getName()+".txt");
        WriteClass.write(p,fw);
	fw.close();
    }
}