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
 * @author blueg
 */
public class FunctionIdentityBasic {
    public static void main(String[] args) {
        Random num = new Random();
        int x = num.nextInt(30);
        
        Function<Integer,Integer> id = Function.identity(); //Returns a function that always returns its input argument.

        System.out.println(x);
        System.out.println(id.apply(x)); //the input is the random number x, thus it will return x.
        
        
        
    }
}
