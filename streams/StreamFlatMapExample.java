/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author sridh
 */
public class StreamFlatMapExample {
    public static void main(String[] args) 
    {    
        // Creating a list of Prime Numbers 
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13); 
          
        // Creating a list of Odd Numbers 
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5); 
          
        // Creating a list of Even Numbers 
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8); 
  
        List<List<Integer>> listOfLists = 
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers); 
  
        System.out.println("The Structure before flattening is : " + 
                                                  listOfLists); 
          
        // Using flatMap for transformating and flattening. 
        List<Integer> listofInts  = listOfLists.stream() 
                                    .flatMap(list -> list.stream())  // flattens the data....
                                    .collect(Collectors.toList()); 
  
        System.out.println("The Structure after flattening is : " + 
                                                         listofInts); 
    } 
}
