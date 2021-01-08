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
public class FunctionComposeVsAndThen {
    
    public static void main(String[] args) {
        Random num = new Random();
        int x = num.nextInt(30); //generates a random number and store in x.

        Function<Integer, Integer> multiply = a -> a * 2;
        Function<Integer, Integer> subtract = a -> a - 10;

        Function<Integer, Integer> multiplyThenSubtract = multiply.andThen(subtract); //multiply by 2 first then subtract by 10.

        int resultAndThen = multiplyThenSubtract.apply(x);
        System.out.println("Original x is: "+x);
        System.out.println("Applying AndThen method gives: "+resultAndThen);
        
        Function<Integer, Integer> SubtractThenMultiply = multiply.compose(subtract);

        int resultCompose = SubtractThenMultiply.apply(x);
        System.out.println("Original x is: "+x);
        System.out.println("Applying Compose method gives: "+resultCompose); //subtract by 10 first then multiply by 2.
    }
    
    
    
}
