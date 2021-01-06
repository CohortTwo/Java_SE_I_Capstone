/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.iterations;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sridh
 */
// Java program to iterate over an arraylist using Lambda Function 
public class IterationUsingForEachLambda {

    public static void main(String[] args) {
        // initializing ArrayList 
        List<Integer> numbers = Arrays.asList(1, 2, 3,
                4, 5, 6, 7, 8);

        //lambda 
        numbers.forEach(number -> System.out.println(number));

    }
}
