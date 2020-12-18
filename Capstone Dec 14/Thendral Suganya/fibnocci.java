
import java.util.Scanner;

/**
 *
 * @author tthen
 */
public class fibnocci {
   
    
    public static void main(String[] args)
    {
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter a number to get its fibonaci series:");
        int mynum = s1.nextInt();

            int num1 = 0;
            int num2 = 1;
            int temp ; 
            int count = 1; 
              System.out.print("The fibonacci Series is :" + num1 +" "+  num2 +" ");
                  while(count<mynum)  
                  {
                      System.out.print(num1+num2 +" ");
                      temp=num1+num2;
                      num1=num2;
                      num2=temp;
                      count++;
                  }
    }

}
