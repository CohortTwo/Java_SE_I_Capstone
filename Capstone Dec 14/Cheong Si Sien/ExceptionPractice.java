
package pkgabstract;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sridh
 */
public class ExceptionPractice {
    public static void main(String[] args)
    {
     Scanner sc = new Scanner(System.in);
     int id = 0;
     try{
             System.out.println("enter a number:" );
             
             id = sc.nextInt();
                  }
     catch(InputMismatchException ie)
        {
         System.out.println("Incorrect data type used, Please enter a number");
         sc.next();
         id = sc.nextInt();
        }
     }   
   }

     
             
        
    
        
        
        
        
        
        
        
        
       