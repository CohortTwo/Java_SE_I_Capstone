/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

/**
 *
 * @author sridh
 */
public class ArithException {

    public static void main(String args[]) {
        // try {
        int num1 = 30, num2 = 0;
        try {
            int output = num1 / num2;
            System.out.println("Result: " + output);
        } 
                catch (ArithmeticException e) {
                System.out.println(e);
         }
                
        finally {
             System.out.println("You Shouldn't divide a number by zero");
        }

    }
}
