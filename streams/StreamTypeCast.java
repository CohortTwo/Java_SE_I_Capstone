/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sridh
 */
public class StreamTypeCast {

    public static class Employee {

        public String salary;

        public Employee(String salary) {
            this.salary = salary;
        }
    }
    
    public static void main(String[] args){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("5060"));
        list.add(new Employee("6090"));
        list.add(new Employee("3560"));
        list.add(new Employee("7880"));
        list.add(new Employee("8000"));
        
        int sum = 
                list.stream().map(employee -> employee.salary).map(Integer::parseInt).reduce(0, (tmp,total) -> tmp + total);
        
        System.out.println(sum);
        
        
        
        
    }
}
