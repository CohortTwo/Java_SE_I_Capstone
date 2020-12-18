
import java.util.Scanner;

/**
 *
 * @author tthen
 */
public class palindrome {
    

    
     public static void main(String[] args)
    {
       
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter a word to find it is palindrome or not:");
        String myString = s1.nextLine();

        
        String revString = " "; 
      
        for (int i=myString.length(); i>0; i--)
        {
            revString= revString+myString.charAt(i-1);
        }
        
        myString = myString.toLowerCase().trim();
        revString = revString.toLowerCase().trim();
        
       if (myString.equals(revString))
            System.out.println(myString + "is  Palindrome.");
        else
           System.out.println(myString + " is not a Palindrome.");
    }
    
}
