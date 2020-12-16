/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

/**
 *
 * @author sridh
 */
public class StrIndx {
        public static void main(String[] args)
    {
       
        String str = "Reverse terminology";
        String rev = " "; // Variable to store the reverseed string
           
      // looping through the characters starting from the last in the given string
      // taking care to see that the array index is not exceeding limits.
      try {
               
      // looping through the characters starting from the last in the given string
        for (int i=str.length(); i>0; i--)
        {
            rev= rev + str.charAt(i);
            System.out.println(i);
        }
      }catch(StringIndexOutOfBoundsException ex) 
      {
          System.out.println("Please check your program for " + ex);
      }
        
    }
}
