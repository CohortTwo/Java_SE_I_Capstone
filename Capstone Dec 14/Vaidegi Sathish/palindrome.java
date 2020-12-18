/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

import java.util.Scanner;
/**
 *
 * @author Karishma
 */
public class palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String input;
        String output = "";

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the word that you would like to check: ");
        input = sc.nextLine();

        for (int i = input.length()-1; i >= 0; i--) {
            output = output + input.charAt(i);
        }

        if (input.equalsIgnoreCase(output)) {
            System.out.println(input + " is a palindrome!");
        } else {
            System.out.println(input + " is not a palindrome!");
            System.out.println(output);
        }
    }

}
    

