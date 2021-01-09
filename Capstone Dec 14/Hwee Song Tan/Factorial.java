/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrew
 */
public class Factorial {

    
    public static int factorial(int inp) {
           int tmp=1;
        
        for (int i = 1; i <= inp; i++) {
            tmp =tmp*i;
        }
        return tmp;
    }
            
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    int result;
    
    result = factorial(6);
    System.out.println(result);
}
    
}
