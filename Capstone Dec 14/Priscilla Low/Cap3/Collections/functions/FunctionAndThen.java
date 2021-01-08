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
public class FunctionAndThen {
    public static void main(String[] args) {
        Random num = new Random();
        int x = num.nextInt(30);
        
        Function<Integer,Integer> multiply = a-> a*2;
        
        multiply = multiply.andThen(a->a-2);
        
        System.out.println("Original x is: "+x);
        System.out.println("After multiply by 2 and minus 2 gives: "+multiply.apply(x)); //will multiply by 2 first then minus 2.
        
        
    }
}
