/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author sridh
 */
public class InpMismatch {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        {
            try{
            sc.nextInt();    
            }catch(InputMismatchException ie)
            {
                System.out.println("Incorrect data type used, Please enter a number");
            }
            
        }
    }
}
