/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author sridh
 */
public class StreamRandom {
    public static void main(String[] args) {
        Random random = new Random();
         
        //Five random integers
 
        random.ints( 5 ).sorted().forEach( System.out::println );
 
        //Five random doubles between 0 (inclusive) and 0.5 (exclusive)
 
        random.doubles( 5, 0, 0.5 ).sorted().forEach( System.out::println );
 
        //Boxing long to Long so they can be collected
 
        List<Long> longs = random.longs( 5 ).boxed().collect( Collectors.toList() );
        System.out.println(longs);
    }
}
