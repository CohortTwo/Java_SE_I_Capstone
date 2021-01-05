/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.functions;

import java.util.function.Function;
import java.util.Random;

/**
 *
 * @author sridh
 */
public class HalfofInt {
    //Function which takes in a number and returns half of it 

    public static void main(String[] args) {
        Random somenum = new Random();
        int x = somenum.nextInt(1000); // Generating a random number between 1 and 1000.
        Function<Integer, Double> half = a -> a / 2.0;
        System.out.println("Half of "+ x+" is " + half.apply(x));
    }
}
