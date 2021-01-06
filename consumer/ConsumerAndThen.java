/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.consumer;

import java.util.function.Consumer;

/**
 *
 * @author sridh
 */
public class ConsumerAndThen {
    public static void main(String[] args) {
  
	 Consumer<String> lower = x -> System.out.println(x.toLowerCase());
	 Consumer<String> upper = y -> System.out.println(y.toUpperCase());
 
	 Consumer<String> result = lower.andThen(upper);
  
    result.accept("Hello");
 }
}
