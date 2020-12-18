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
public class FiboTesting {
    
    //Fibonacci sequence
    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        int c;
        int count;

        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (i == 0) {

                a = 0;
                b = 1;

                System.out.print(a + " " + b + " ");
            } else {

                c = a + b;
                a = b;
                b = c;

                System.out.print(c + " ");
            }

        }

    }

}
