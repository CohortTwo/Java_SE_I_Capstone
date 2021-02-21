/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sridhar
 */
public class ArayMulti {

    static List multi_dimensional() {
        ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
        x.add(new ArrayList<Integer>());
        x.get(0).add(0, 45);
        x.add(new ArrayList<Integer>(Arrays.asList(56, 67, 89)));
        x.get(1).add(0, 67);
        x.get(1).add(4, 456);
        x.add(2, new ArrayList<>(Arrays.asList(23, 32)));
        x.add(new ArrayList<Integer>(Arrays.asList(83, 64, 77)));
        x.add(new ArrayList<>(Arrays.asList(8)));
        return x;
    }

    public static void main(String args[]) {
        System.out.println("The multidimensional arraylist is :");
        System.out.println(multi_dimensional());
    }
}
