
import java.util.Scanner;


/**
 *
 * @author tthen
 */
public class numRev {
    
    public static void main(String args[]){
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter a number to find its reverse number:");
        int mynum = s1.nextInt();
         
          int r, newnum=0;

          while(mynum>0){

              r = mynum%10;

              newnum = newnum * 10 + r;

              mynum = mynum/10;
         }

         System.out.println("Reverse of the given number is : "+newnum);

    }
    
    
}
