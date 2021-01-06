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
public class StreamCountExample {

    public static void main(String[] args) {

        // creating a list of Integers 
        List<Integer> list = Arrays.asList(0, 2, 4, 6,
                8, 10, 12,565,77);

        // Using count() to count the number of elements in the stream and 
        // storing the result in a variable. 
        long total = list.stream().count();

        // Displaying the number of elements 
        System.out.println(total);
    }
}
