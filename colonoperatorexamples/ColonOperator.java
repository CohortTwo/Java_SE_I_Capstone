/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colonoperatorexamples;

import java.util.stream.Stream;

/**
 *
 * @author sridh
 */
public class ColonOperator {

    public static void main(String[] args) {

        // Get the stream 
        Stream<String> stream
                = Stream.of("The", "World",
                        "is", "not",
                        "enough");

        // Print the stream using double colon operator 
        stream.forEach(System.out::println); 
        // the alternate way is as shown below
        //stream.forEach(s -> System.out.println(s));

    }

}

