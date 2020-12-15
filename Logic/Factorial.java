/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sridhar
 */
public class Factorial {

    public static void main(String args[]) {

        int num = 4;               // Variable to hold number for which the factorial will be calculated.  

        int result = 1;           // Temp Variable to store the result.

        System.out.print("Factorial of " + num);

        while (num > 0) {

            result = result * num;

            num--;

        }

        System.out.println(" is : " + result);

    }
}
