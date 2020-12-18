
import java.util.Scanner;

/**
 *
 * @author tthen
 */
public class factorial {
     public static void main(String args[]) {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter a number to find its factorial:");
        int mynum = s1.nextInt();
        int fact = 1;
        while (mynum > 0) {
            fact = fact * mynum;
            mynum--;
        }

        System.out.println(" Factorial of given number is : " + fact );
    }
}

