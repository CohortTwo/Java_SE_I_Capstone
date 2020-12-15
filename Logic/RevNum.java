/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sridhar
 */
public class RevNum {
   
    public static void main(String args[]){

          int num = 1234;               

          int remainder, result=0;

          while(num>0){

              remainder = num%10;

              result = result * 10 + remainder;

              num = num/10;
         }

         System.out.println("Reverse number is : "+result);

    }

}
