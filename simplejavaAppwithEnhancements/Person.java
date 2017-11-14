/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

/**
 *
 * @author giandimi
 */
public class Person {
    private   String name;
    private   String lname;
    private   String fname;
    private   String dateofbirth;
    private int age;
    
    public String getName() {
	return name;
    }
     public String getLname() {
        return lname;
    }
    public String getFname() {
        return fname;
    }
    public String getDob() {
        return dateofbirth;
    }
    public int getAge() {
        return age;
    }
    public void setString(int param,String s){
        switch (param) {
            case 1:  this.name = s;
                     break;
            case 2:  this.lname = s;
                     break;
            case 3:  this.fname = s;
                     break;
            case 4:  this.dateofbirth = s;
                     break;
           
            default: 
                     break;
        }
    }
  
    public void setString(int age) {
        this.age = age;
    }
    
}

