package demo;

import java.util.Scanner;

public class Demo {

    static String temp;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String s1 = "Hello";
        temp = "";

        for (int i = s1.length(); i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("------------");
        for (int i = s1.length(); i > 0; i--) {
            System.out.println(s1.charAt(i - 1));

        }
        System.out.println("------------");

        for (int i = s1.length(); i > 0; i--) {
            temp = temp + s1.charAt(i - 1);

            System.out.println(temp);

        }
    }
}
