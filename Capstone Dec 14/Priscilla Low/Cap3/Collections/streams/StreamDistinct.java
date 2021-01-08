/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author blueg
 */
public class StreamDistinct {
    public static void main(String[] args) {
        
        Collection<String> myList = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        
        List<String> distinctElements = myList.stream()
                .distinct()
                .collect(Collectors.toList());
        
        System.out.println(distinctElements);
                

    }
}
