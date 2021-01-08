/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predicateFunction;

import function.Employee;
import java.util.ArrayList;
import static predicateFunction.EmpPredicate.*;
import java.util.Arrays;
import java.util.List;
import function.FunctionEmp;
import static function.FunctionEmp.convertEmpList2NameList;
import function.Gender;
import java.util.function.Function;

//import static predicateFunction.EmpPredicate.isAdult;

/**
 *
 * @author chiangyong
 */
public class TestEmpPredicate {
    
    public static void main(String agrs[])
    {
        Function<Employee, String> fnEmp2Str = (Employee e) -> {return e.getName()+", "+e.getAge()+", "+e.getGender()
                ;};
        List<Employee> empList = new ArrayList<Employee>();
                
               empList.addAll(Arrays.asList(
                new Employee("Tom Becker",32,"TomBecker",100,Gender.Male),
                new Employee("Lucky Mar",45,"LuckyMar",101,Gender.Female),
                new Employee("Rose Happy",18,"RoseHappy",102,Gender.Female),
                new Employee("Starky Mick", 38,"StarkyMick",103,Gender.Male),
                new Employee("Sky Rock", 16, "SkyRock",104,Gender.Male),
                new Employee("Nancy Dolly",66,"Nancy",105,Gender.Female),
                new Employee("Suzie Drew", 25,"Suzie",106,Gender.Female),
                new Employee("Emily Hunter",48,"Emily",107,Gender.Female),
                new Employee("Larry Phillip", 58,"LarryP", 108, Gender.Male),
                new Employee("Michelle Cristian",20,"MichelleC",109,Gender.Female)));
        
        
     //   EmpPredicate empP = new EmpPredicate();
        
       System.out.println(filterEmp(empList, isAdult()).toString());
       System.out.println(filterEmp(empList, isMale()));
       System.out.println(filterEmp(empList, isAgeMoreThan(35)));
       System.out.println(filterEmp(empList, isSenior()));
       System.out.println(filterEmp(empList, isMale().negate()));
       
       System.out.println("\n Employee Name Age and Gender");
       List<String> nameList = convertEmpList2NameList(empList,fnEmp2Str);
       nameList.forEach(System.out::println);
       
       System.out.println("\n Sort Employee according to Age");
       sortEmp(empList);
       
       System.out.println("\nGender Male");
       prnList(empList,isMale());
       
       System.out.println("\nGender Female");
       prnList(empList,isMale().negate());
        
       System.out.println("\nSenior Citizen");
       prnList(empList,isSenior());
    }
    
}
