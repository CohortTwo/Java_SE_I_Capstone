/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.util.HashMap;

/**
 *
 * @author sridh
 */
public class HMap {
    public static void main(String[] args) {
    // Create a HMap object called capitalCities
    HashMap<Integer, String> cityCode = new HashMap<Integer, String>();

    // Add keys and values (Country, City)
    cityCode.put(1, "London");
    cityCode.put(2, "Berlin");
    cityCode.put(3, "Oslo");
    cityCode.put(4, "Washington DC");
    System.out.println(cityCode);
  }
}
