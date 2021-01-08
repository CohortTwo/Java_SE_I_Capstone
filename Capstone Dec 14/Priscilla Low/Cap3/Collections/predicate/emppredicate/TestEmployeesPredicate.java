/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.predicate.emppredicate;

import static Collections.predicate.emppredicate.EmployeePredicates.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author blueg
 */
public class TestEmployeesPredicate {
    public static void main(String[] args) {
        
        Employees e1=new Employees(1,20,"F","Samantha","Fok");
        Employees e2=new Employees(2,30,"M","Simon","Tam");
        Employees e3=new Employees(3,35,"M","Berhard","Tan");
        Employees e4=new Employees(4,32,"M","Simon","Tam");
        Employees e5=new Employees(5,28,"F","Joanne","Tay");
        Employees e6=new Employees(6,24,"F","Joni","Lim");
        Employees e7=new Employees(7,29,"M","Engs","Wong");
        Employees e8=new Employees(8,50,"F","Aarthy","Lim");
        Employees e9=new Employees(9,46,"M","Foo","Chan");
        Employees e10=new Employees(10,24,"F","Elizabeth","Qian");
        
        List<Employees> employees = new ArrayList<Employees>();
        employees.addAll(Arrays.asList(new Employees[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
        
        System.out.println(filterEmployees(employees,isAdultMale()));
        System.out.println(filterEmployees(employees,isAdultFemale()));
        System.out.println(filterEmployees(employees,isAgeMoreThan(40)));
        System.out.println(filterEmployees(employees,isAgeMoreThan(40).negate()));
    }
}
