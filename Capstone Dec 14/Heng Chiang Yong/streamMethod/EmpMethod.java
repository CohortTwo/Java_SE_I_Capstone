/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamMethod;

import function.Employee;
import function.Gender;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static predicateFunction.EmpPredicate.isAdult;
import static predicateFunction.EmpPredicate.*;


/**
 *
 * @author chiangyong
 */
public class EmpMethod {
    
    List<Employee> emp = new ArrayList<Employee>();
    
    public static void main(String args[])
    {
  
        List<Employee> emp = new ArrayList<Employee>();
        emp.addAll(Arrays.asList(
                new Employee("Kelly Lee", 66,"KellyLee", 99,Gender.Female,25000f,"24-01-2003","President","Executive"),
                new Employee("Tom Becker",52,"TomBecker",100,Gender.Male,24000f,"24-01-2003","CEO","Executive"),
                new Employee("Lucky Mar",45,"LuckyMar",101,Gender.Male, 10000f,"15-06-2003","Manager","IT"),
                new Employee("Rose Happy",48,"RoseHappy",102,Gender.Female,20000f,"03-07-2003","VP","Sales"),
                new Employee("Starky Mick", 38,"StarkyMick",103,Gender.Male, 8000f,"05-07-2003","Engineering Manager","Engineering"),
                new Employee("Sky Rock", 47, "SkyRock",104,Gender.Male,5000f,"08-07-2003","Snr Engineer", "Engineering"),
                new Employee("Nancy Dolly",46,"Nancy",105,Gender.Female,7000f,"09-07-2003","HR Manager","Administrative"),
                new Employee("Suzie Drew", 35,"Suzie",106,Gender.Female,6000f,"08-08-2005","IT Engineer","IT"),
                new Employee("Emily Hunter",48,"Emily",107,Gender.Female,6600f,"09-09-2005","Sales Rep","Sales"),
                new Employee("Larry Phillip", 20,"LarryP", 108, Gender.Male, 3500f,"01-10-2019","Engineer","Engineering"),
                new Employee("Michelle Cristian",19,"MichelleC",109,Gender.Female, 3000f,"01-05-2020","Software Engineer","Engineering")));
         
        //toList
        List<String> listOfEmps = emp.stream()
                .limit(11)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(listOfEmps);
        
        //toSet
        Set<String> setOfEmps = emp.stream()
                .limit(11)
                .map(Employee::getName)
                .collect(Collectors.toSet());
        System.out.println(setOfEmps);
        
        //toMap
        Map<String, Employee> mapEmps;
        mapEmps = emp.stream()
              //  .limit(11)
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .collect(Collectors.toMap(e -> e.getName(), e -> e));
        
        System.out.println(mapEmps);
        
        
        //to find employees where salary is more than 5000
         emp.stream()
                .filter(isSalaryMoreThan(5000f))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(e -> e.getName()+", "+e.getSalary()+", "+e.getDept())
                .forEach(System.out::println);                          //a method reference
         
         Map<String, List<Employee>> empByDept
                 =emp.stream()
                 .collect(Collectors.groupingBy(e -> e.getDept()));
                 
         
         //System.out.println(empByDept.values());
        
        // String names[] = {"john","mick","larry","lucy","doris"};
         
        //for loop
         for(String name : empByDept.keySet())        //keySet() to retrieve Department name
        {
          System.out.println(name);                     //print the department name
          System.out.println(empByDept.get(name));      //print employee information 
        }
         
         System.out.println("\nforEach version");
         //forEach
         empByDept.keySet().forEach(name -> {
             System.out.println(name);
             System.out.println(empByDept.get(name));
         });
         
         //entrySet of a Map
         System.out.println("\nEntrySet of Map print out");
         empByDept.entrySet().forEach(entry -> System.out.println(entry.getKey()+"\n "+entry.getValue()));
    }
        
}
    

