/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;
import java.util.ArrayList;
/**
 *
 * @author sridh
 */
public class EmpMgmt {
    public static void main(String[] args)
    {
        ArrayList<Employee> emp = new ArrayList<Employee>();
        emp.add(new Employee(100,"Simon",45,"M","Mktg",1090.4));
        emp.add(new Employee(101,"Sally",35,"F","Sales",1404.4));
        emp.add(new Employee(102,"James",52,"M","Admin",1550.4));
        
        System.out.println("Id= " + emp.get(0).id);
        System.out.println("Name= " + emp.get(0).name);
        System.out.println("Age= " + emp.get(0).gender);
        System.out.println("Department= " + emp.get(0).dept);
        System.out.println("Salary= " + emp.get(0).sal);        
    }
            
}
