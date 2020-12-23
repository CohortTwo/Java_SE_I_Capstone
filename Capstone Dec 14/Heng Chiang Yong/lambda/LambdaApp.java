/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

/**
 *
 * @author chiangyong
 */

@FunctionalInterface
interface mathLambda{
    double math(float a, float b);
}

    
public class LambdaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        mathLambda add = (a,b)-> a+b;
        mathLambda sub = (a,b)-> a-b;
        mathLambda mul = (a,b)-> a*b;
        mathLambda div = (a,b)-> { if(b==0) return 0; return (a/b);};
        
        System.out.println(add.math(2.5f, 3));
        System.out.println(sub.math(2, 3));
        System.out.println(mul.math(20, 3));
        System.out.println(div.math(8, 6));
    }
    
}
