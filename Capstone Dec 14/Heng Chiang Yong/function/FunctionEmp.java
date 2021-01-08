/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.util.function.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author chiangyong
 */
public class FunctionEmp {
    
 //  Employee emp = new Employee();
    
    public static List<String> convertEmpList2NameList(List<Employee> empList,Function<Employee,String> fnEmp2Str)
    {
        List<String> empNameList = new ArrayList<String>();
        for(Employee emp:empList)
        {
            empNameList.add(fnEmp2Str.apply(emp));
        }
        
        return empNameList;
        
    }
    
    public static void main(String args[])
    {
       // Employee emp = new Employee();
        Function<Employee, String> fnEmp2Str = (Employee e) -> {return e.getName();};
        List<Employee> empList = Arrays.asList(new Employee("Tom Tom",32),
                new Employee("Lucky Lucky",45),
                new Employee("Happy, Happy",25),
                new Employee("Starky Starky", 38),
                new Employee("Sky Sky", 16));
        List<String> empNameList = convertEmpList2NameList(empList,fnEmp2Str);
        empNameList.forEach(System.out::println);
    }
}
