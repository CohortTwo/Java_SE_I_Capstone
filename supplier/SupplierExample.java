/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.supplier;

import java.util.function.Supplier;

/**
 *
 * @author sridh
 */
public class SupplierExample {
    public static void main(String args[]) 
    { 
  
        // This function returns a random value. 
        Supplier<Double> randomValue = () -> Math.random(); 
  
        // Print the random value using get() 
        System.out.println(randomValue.get()); 
    } 
}
