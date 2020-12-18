//Calculator methods below.
package logic;

import calculator.Calculator;
/**
 *
 * @author blueg
 */
public class CalcImp implements Calculator{
    
    float result;
    public float add(float a, float b){
        
        return result = a+b;
    }
    
    public float sub(float a, float b){
        return result = a-b;
    }
    
    public float div(float a, float b){
        return result = a/b;
    }
    
    public float mult(float a, float b){
        return result = a*b;
    }
    
    //Can also write the public static void main in a separate file, i.e. CalculatorMain.java
    public static void main(String[] args) {
        CalcImp calculator = new CalcImp(); //create a calculator object
        System.out.println(calculator.add(34.55f,2.33f));
        System.out.println(calculator.sub(34.55f,2.33f));
        System.out.println(calculator.div(30.00f,2.00f));
        System.out.println(calculator.mult(10.00f,2.0f));
    }
    
}
