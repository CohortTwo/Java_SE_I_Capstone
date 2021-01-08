/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predicateFunction;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import function.Employee;
import function.Gender;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 * @author chiangyong
 */
public class EmpPredicate {
       
    public static Predicate<Employee> isAdult()
    {
        return p -> p.getAge() > 21;
    }
    
    public static Predicate<Employee> isMale()
    {
        return p -> p.getGender().equals(Gender.Male);
    }
    
    public static Predicate<Employee> isSenior()
    {
        return p -> p.getAge() > 65;
    }
    
    public static Predicate<Employee> isAgeMoreThan(Integer age)
    {
        return p -> p.getAge() > age;
    }
    
    public static Predicate<Employee> isSalaryMoreThan(Float salary)
    {
        return p -> p.getSalary() > salary;
    }
    
    public static List<Employee> filterEmp(List<Employee> emp, Predicate<Employee> predicate)
    {
        
        return emp.stream()
                .filter(predicate)
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.<Employee>toList());
        
    }
    
    public static void sortEmp(List<Employee> emp)
    {     
          emp.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed())
                  .map(e -> e.getName() +", "+e.getAge()).forEach(System.out::println);
    }
    
    public static void prnList(List<Employee> emp,Predicate<Employee> predicate)
    {
        emp.stream()
                .filter(predicate)
                .sorted(Comparator.comparingInt(Employee::getAge))
                .map(e -> e.getName()+", "+e.getGender()+", "+e.getAge())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
