/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrew
 */
public class fibonaci {

    
    public static void fibon(int inp) {
           int a=0;
           int b=1;
           int tmp;
        System.out.print(a+":");
        System.out.print(b+":");
        
        for (int i = 0; i < inp; i++) {
            tmp =a+b;
          System.out.print(tmp+":");
          a=b;
          b=tmp;
        }
    }
            
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    fibon(10);

}
    
}
