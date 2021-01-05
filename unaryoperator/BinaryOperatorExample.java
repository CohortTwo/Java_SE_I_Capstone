/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.unaryoperator;

import java.util.function.BinaryOperator;

/**
 *
 * @author sridh
 */
public class BinaryOperatorExample {
   public static void main(String[] args) {
      BinaryOperator<Person> getMax = BinaryOperator.maxBy((Person p1, Person p2) -> p1.age-p2.age);

      Person person1 = new Person("Simon", 23);
      Person person2 = new Person("David", 29);
      Person maxPerson = getMax.apply(person1, person2);
      System.out.println("Person with higher age : \n"+ maxPerson);

      BinaryOperator<Person> getMin = BinaryOperator.minBy((Person p1, Person p2) -> p1.age-p2.age);
      Person minPerson = getMin.apply(person1, person2);
      System.out.println("Person with lower age : \n"+ minPerson);
   }
}

// Person class
class Person {
   public String name;
   public Integer age;
   public Person(String name, Integer age) {
      this.name = name;
      this.age = age;
   }
   @Override
   public String toString(){
      return "Name : "+name+", Age : "+age;
   } 
}
