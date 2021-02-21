/*Write a program to find whether given no. is Armstrong or not.

  Example :

           Input - 153

           Output - 1^3 + 5^3 + 3^3 = 153, so it is Armstrong no. */

class Armstrong{

      public static void main(String args[]){

      int num = Integer.parseInt(args[0]);

      int n = num; //use to check at last time

      int check=0,remainder;

      while(num > 0){

           remainder = num % 10;

           check = check + (int)Math.pow(remainder,3);

           num = num / 10;

      }

      if(check == n)

            System.out.println(n+" is an Armstrong Number");

      else

            System.out.println(n+" is not a Armstrong Number");

   }

}

