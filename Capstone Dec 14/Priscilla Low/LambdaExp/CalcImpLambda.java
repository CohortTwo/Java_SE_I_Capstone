/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaExp;

/**
 *
 * @author blueg
 */
interface CalcLambda {
    double CalcLambda(double a, double b);
}

public class CalcImpLambda{
    public static void main(String[] args) {
        CalcLambda addLambda = (a, b) -> a + b;
        CalcLambda subLambda = (a, b) -> a - b;
        CalcLambda multLambda = (a, b) -> a * b;
        CalcLambda divLambda = (a, b) -> {
            if (b==0.0) 
                return 0.0; 
            return a / b;
        };
        
        System.out.println("Sum is: " + addLambda.CalcLambda(10, 20));
        System.out.println("Difference is: " + subLambda.CalcLambda(20, 10));
        System.out.println("Product is: " + multLambda.CalcLambda(20, 2));
        System.out.println("Division result: " + divLambda.CalcLambda(20, 2));
          
    }
}
