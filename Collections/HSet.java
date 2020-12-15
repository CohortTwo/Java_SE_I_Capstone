/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.util.HashSet;

/**
 *
 * @author sridhar
 */
public class HSet {

    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");  // ignored as it is repeated
        if (cars.contains("BMW")) {
            cars.add("Mercedez");
        } else {
            cars.add("BMW");
        }
        cars.add("Mazda");
        System.out.println(cars);

    }
}
