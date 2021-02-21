/*Write a program to Reverse a given no. */

class Reverse{

      public static void main(String args[]){

          int num = Integer.parseInt(args[0]);               //take argument as command line

          int remainder, result=0;

          while(num>0){

              remainder = num%10;

              result = result * 10 + remainder;

              num = num/10;

         }

         System.out.println("Reverse number is : "+result);

    }

}