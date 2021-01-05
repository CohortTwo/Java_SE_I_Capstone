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
public class FunctionIdentityBasic {
    
      

    public static void main(String[] args) {
        
         Random somenum = new Random();
        int x = somenum.nextInt(1000); // Generating a random number between 1 and 10.
        
        Function<Integer, Integer> id = Function.identity();  //Java 8 identity function Function.identity() 
                                                                //returns a Function that always returns it’s input argument.

        System.out.println(id.apply(x));

    }
}
