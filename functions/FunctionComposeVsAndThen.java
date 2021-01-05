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
public class FunctionComposeVsAndThen {

    public static void main(String[] args) {

        Random somenum = new Random();
        int x = somenum.nextInt(10); // Generating a random number between 1 and 1000.

        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add = (value) -> value + 3;

        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);
        Function<Integer, Integer> addThenMultiply = multiply.compose(add); // first applies the compose(add) method 
        // and passes the result to the multiply method

        int resultOfAndThen = multiplyThenAdd.apply(x);
        int resultOfCompose = addThenMultiply.apply(x);
        System.out.println("The random number used is " + x);
        System.out.println("The andThen() Method is applied and result is " + resultOfAndThen);
        System.out.println("The compose() isapplied and the result is " + resultOfCompose);
    }
}
