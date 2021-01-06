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
 * @author sridh
 */
public class StreamDistinct {

    public static void main(String[] args) {
        Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

// Get collection without duplicate i.e. distinct only
        List<String> distinctElements = list.stream()
                .distinct()
                .collect(Collectors.toList());

//Let's verify distinct elements
        System.out.println(distinctElements);
    }
}
