/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sridhar
 */
public class SwapVars {
    int v1 = 10;
    int v2 = 20;
    
    // Swapping values of variables with temporary variable
    
    void swap()
    {
        int temp = v1;
        v1= v2;
        v2= temp;
         System.out.println("V1 is "+ v1 + " and V2 is " + v2);
    }
    
    void simpleSwap()
            
     // Swapping values of variables without a  temporary variable
    {
        v1 = v1 + v2;
        v2 = v1- v2;
        v1 = v1- v2;
         System.out.println("V1 is "+ v1 + " and V2 is " + v2);
    }
    
    public static void main(String [] args)
    {
        // Creating an instance of the Swap Class.
       SwapVars sw= new SwapVars();
       
       System.out.println(" Original Values");
       System.out.println("v1 is " + sw.v1 + " and V2 is " + sw.v2);
       
       System.out.println(" Swapping for the first time with a temp Variable");
       sw.swap();
       
       System.out.println(" Swapping for the second time without a temp variable");
       sw.simpleSwap();
    }
}
