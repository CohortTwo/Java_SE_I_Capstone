
public class FibNums {

    
    public static void main(String[] args)
    {
            int n1 = 0;
            int n2 = 1;
            int temp ; // Variable used to swap the variable's value befor incrementing it.
            int count = 1; // variable to define the length of series
              System.out.print(" " + n1 +" "+  n2 +" ");
                  while(count<9)  //Looping to ste the length of series as 10.
                  {
                      System.out.print(n1+n2 +" ");
                      temp=n1+n2;
                      n1=n2;
                      n2=temp;
                      count++;
                  }
    }
}
