package factorapp;

import java.util.Scanner;

public class FactorApp {

    public static int factorial(int n) {
        if (n==1) return n;
        else {
                n = n * factorial(n-1);
                }
        return n;
    }
    
    public static void main(String[] args) {
        System.out.print("Enter a number to factorial :");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        System.out.println("Factorial of " + num + " = " + factorial(num));
    }
}
