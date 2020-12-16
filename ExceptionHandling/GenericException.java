/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

import java.util.*;

/**
 *
 * @author sridh
 */
public class GenericException {

    public static void main(String args[]) {
        int[] nu = {4, 8, 12, 16};
        int[] de = {2, 4, 8, 8};

        for (int i = 0; i < nu.length; i++) {
            try {
                System.out.println(nu[i] / de[i]);
            } catch (ArithmeticException ex) {
                System.out.println("In the catch block");
            }
        }
        System.out.println("Rest of my code");
    }
}
