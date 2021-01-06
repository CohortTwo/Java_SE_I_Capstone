/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author sridh
 */
public class StreamPeekExample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.stream()
                .peek(System.out::println)
                .collect(Collectors.toList())
                ;  // Without the terminal operation the .pek will not print anything.

       
    }
}
