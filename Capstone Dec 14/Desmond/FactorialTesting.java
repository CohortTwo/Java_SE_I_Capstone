/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmanipulation;

import java.util.Scanner;

/**
 *
 * @author Desmond
 */
public class FactorialTesting {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int count = 1;
        // eg. 4! = 1x2x3x4
        System.out.println("Please enter the number to factorial ");
        int number = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            count = count * i;
        }
        System.out.println("The amount using the ascending method is " + count);

        facNeg();
    }

    public static void facNeg() {
        // eg. 4! = 4x3x2x1
        System.out.println("Please enter for the reverse method: ");

        int count = sc.nextInt();

        for (int i = count; i > 1; i--) {

            count = count * (i - 1);
            System.out.println("The amount is ..." + count);

        }
        System.out.println("The amount is " + count);
    }

}
