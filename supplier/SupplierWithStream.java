/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.supplier;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author sridh
 */
public class SupplierWithStream {
    public static void main(String[] args) {
 
		Supplier<Integer> randomNumbersSupp=() -> new Random().nextInt(10);
		Stream.generate(randomNumbersSupp).limit(8).forEach(System.out::println);
	}
}
