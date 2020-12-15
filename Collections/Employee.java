/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

/**
 *
 * @author sridh
 */
public class Employee {

    int id;
    String name;
    int age;
    String gender;
    String dept;
    double sal;

    public Employee(int id, String name, int age, String gender, String dept, double sal) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sal = sal;

    }

     public int getId() {
        return id;
     }
     public String getName() {
        return name;
    }
    
     public int getAge() {
        return age;
     }
     
     public String getGender() {
        return gender;
     }
     
     public double getSal() {
        return sal;
     }
    
}

