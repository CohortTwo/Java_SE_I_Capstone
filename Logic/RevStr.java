/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sridhar
 */
public class RevStr {
    
    public static void main(String[] args)
    {
        // Declaring a string to be reversed
        String str = "Reverse terminology";
        String rev = " "; // Variable to store the reverseed string
        
      // looping through the characters starting from the last in the given string
        for (int i=str.length(); i>0; i--)
        {
            rev= rev + str.charAt(i-1);
        }
        // Converting the entire String to ower case and display the same.
        System.out.println(rev.toLowerCase());
    }
}
