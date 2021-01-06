/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author sridh
 */
public class StringConcatenate {

 
        public static void main(String[] args) 
    { 
        // Creating two Streams 
        Stream<String> stream1 = Stream.of("One", "Two"); 
        Stream<String> stream2 = Stream.of("Three", "Four"); 
  
        // concatenating both the Streams 
        // with Stream.concat() function 
        // and displaying the result 
        Stream.concat(stream1, stream2) 
            .forEach(element -> System.out.println(element)); 
    } 
}
