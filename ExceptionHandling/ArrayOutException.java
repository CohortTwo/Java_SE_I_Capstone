/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author sridh
 */
public class ArrayOutException {

    public static void main(String args[]) {
        String[] myArray = {"Simon", "Stalin", "Andrew", "Raymond", "Sridhar", "Robert", "Nathan"};
        System.out.println("Elements in the array are:: ");
        System.out.println(Arrays.toString(myArray));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the index of the required element ::");
        try {
            String s = null;
            int element = sc.nextInt();
            System.out.println("Element in the given index is :: " + myArray[element]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index you have entered is invalid");
            System.out.println("Please enter an index number between 0 and 6");
        }
        catch (Exception e1) {
            System.out.println("Second Catch block");
            System.out.println(e1);
            
    }
}
}
