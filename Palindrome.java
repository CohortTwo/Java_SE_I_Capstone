/* Write a program to find whether no. is palindrome or not.

   Example :

           Input - 12521 is a palindrome no.

           Input - 12345 is not a palindrome no. */

class Palindrome{

      public static void main(String args[]){

          int num = Integer.parseInt(args[0]);

          int n = num; //used at last time check

          int reverse=0,remainder;

          while(num > 0){

                remainder = num % 10;

                reverse = reverse * 10 + remainder;

                num = num / 10;

           }

          if(reverse == n)

              System.out.println(n+" is a Palindrome Number");

          else

              System.out.println(n+" is not a Palindrome Number");

     }

}