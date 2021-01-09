/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author andrew
 */
public class ExceptionHandling {
    
    public static void main(String args[]){
    
        int[] numerator = {10,20,30,40};
        int[] denominator = {1,2,0,20};
        int n =0;
        int d =0;
                
        
        for (int i=0; i<numerator.length; i++){
        n= numerator[i];    
        d= denominator[i];
        try{
            
            System.out.println(n/d);
        } catch (Exception e){
            System.out.println("cannot divide by zero");
           
        }
    }
    
}
    
}
