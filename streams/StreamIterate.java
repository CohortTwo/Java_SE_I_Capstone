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
public class StreamIterate {
        public static void main(String[] args){  
        Stream.iterate(1, element->element+1)  
        .filter(element->element%5==0)  
        .limit(10)  
        .forEach(System.out::println);   // Method references using the double colon.
    } 
}
