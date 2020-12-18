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
public class CalculatorApp implements MathOperator{

    /**
     * @param num1
     * @param num2
     * @param args the command line arguments
     */
    
   // @Override
    public float sum(float num1, float num2){
       return num1 + num2;
    }
    
   // @Override
    public float sub(float num1, float num2){
        return num1 - num2;
    }
    
  //  @Override
    public float mult(float num1, float num2){
        return num1*num2;
    }
    
    public float div(float num1, float num2){
        try{
           return num1/num2;
        }
        catch (ArithmeticException ex)
        {
                System.out.println("Cannot be divided by zero");
                return 0;
        }
    }
    
    public int mod(int num1, int num2){
        try
        {
        return num1%num2;
        }
        catch (ArithmeticException ex){
            System.out.println("Cannot mod with zero");
            return 0;
        }
    }
    
   
    
}