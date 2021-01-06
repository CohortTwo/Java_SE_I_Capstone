/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sridh
 */
public class StreamExample {
     public static void main(String[] args) {

        List<String> myFirstStream = Arrays.asList("a1", "a2", "b1", "c2", "c0","c1","d2");

        myFirstStream.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
