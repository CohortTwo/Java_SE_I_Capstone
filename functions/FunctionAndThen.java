/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.functions;

import java.util.Random;
import java.util.function.Function;

/**
 *
 * @author sridh
 */
public class FunctionAndThen {

    public static void main(String args[]) {

        Random somenum = new Random();
        int x = somenum.nextInt(10); // Generating a random number between 1 and 10.

        // Function which takes in a number and returns half of it 
        Function<Integer, Double> half = a -> a / 2.0;

        // Now multiply the output of half function by 3 times
        half = half.andThen(a -> 3 * a);

        // apply the function to get the result 
        System.out.println("3 times of half of " + x + " is " + half.apply(x));
    }
}
