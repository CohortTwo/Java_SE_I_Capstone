/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sridh
 */
public class InpMisMatch1 {

    public static void main(String[] args) {
        int temp = 0;
        Scanner sc = new Scanner(System.in);
        {
                try {
                    temp = sc.nextInt();
                    } catch (InputMismatchException ie) {
                    System.out.println("Incorrect data type used, Defaulting the value to 999");
                    temp = 999;
                }
            }

        }
    }

