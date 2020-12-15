/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sridh
 */
public class StrPalindrome {
    
     public static void main(String[] args)
    {
        // Declaring a string to be reversed
        String str = "Malayalam";
        String rev = " "; // Variable to store the reverseed string
        
      // looping through the characters starting from the last in the given string
        for (int i=str.length(); i>0; i--)
        {
            rev= rev + str.charAt(i-1);
        }
        // Converting the entire String to ower case and display the result
        str = str.toLowerCase().trim();
        rev = rev.toLowerCase().trim();
        
       if (str.equals(rev))
            System.out.println(str + " Palindrome");
        else
           System.out.println(str + " Not a Palindrome");
    }
    
}
