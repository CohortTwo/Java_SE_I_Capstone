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
 * @author blueg
 */
public class StreamExample {
    public static void main(String[] args) {
        
        List<String> myStream = Arrays.asList("a1", "a2", "b1", "c2", "c0","c1","d2");
        
        myStream.stream()
                .filter(p->p.endsWith("2"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
