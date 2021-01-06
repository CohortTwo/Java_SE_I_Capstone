/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.Arrays;

/**
 *
 * @author sridh
 */
public class StreamExample1 {
    public static void main(String[] args) {

        Arrays.asList(1,2,3)
            .stream()
            .findFirst()
            .ifPresent(System.out::println);
    }
}
