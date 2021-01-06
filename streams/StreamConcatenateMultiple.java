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
public class StreamConcatenateMultiple {
    public static void main(String[] args) 
    { 
        // Creating two Streams 
        Stream<String> stream1 = Stream.of("One", "Two"); 
        Stream<String> stream2 = Stream.of("Three", "Four"); 
        Stream<String> stream3 = Stream.of("Five", "Six"); 
        Stream<String> stream4 = Stream.of("Seven", "Eight"); 
        
        Stream.concat(Stream.concat(Stream.concat(stream1, stream2),stream3),stream4)
                .forEach(element -> System.out.println(element));
}
}
