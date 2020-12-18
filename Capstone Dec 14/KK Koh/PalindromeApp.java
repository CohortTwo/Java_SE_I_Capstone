package palindromeapp;

import java.util.Scanner;

public class PalindromeApp {

    public static void main(String[] args) {
        boolean palindrome = true;
        System.out.print("Enter a string to check for Palindrome :");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                palindrome = false;
                break;
            }
        }
        if (palindrome) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is not a Palindrome!");
        }
    }
}
