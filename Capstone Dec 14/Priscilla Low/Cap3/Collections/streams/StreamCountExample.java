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
public class StreamCountExample {
    public static void main(String[] args) {
        
        List<Integer> myStream = Arrays.asList(22, 2, 4, 6, 8, 10, 12,565,77);
        
        long results = myStream.stream()
                                .count(); //count the number of elements in the stream, returns long.

        System.out.println(results);
                

    }
}
