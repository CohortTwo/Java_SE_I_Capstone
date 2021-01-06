/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.stream.Stream;

/**
 *
 * @author sridh
 */
public class StreamFibonacci {
    public static void main(String[] args) {
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
		.limit(10)
		.map(n -> n[0])
		.forEach(x -> System.out.println(x));
    }
 
}
