/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capp;

/**
 *
 * @author chiangyong
 */
public class MainCalculator {
    
    
     public static void main(String[] args) {
        // TODO code application logic here
        
        CalculatorApp cal = new CalculatorApp();
        System.out.println("Sum of 2 and 5 = " + cal.sum(2,5));
        System.out.println("Substract 3 from 10 = " + cal.sub(10,3));
        System.out.println("Multiply of 5 by 10 = " + cal.mult(5,10));
        System.out.println("Divide 100 by 20 = " + cal.div(100,20));
        System.out.println("Mod of 99 by 7 = " + cal.mod(99,7));
        
        cal.display();
        MathOperator.staticDisplay();   //Main interface 
    }
}
