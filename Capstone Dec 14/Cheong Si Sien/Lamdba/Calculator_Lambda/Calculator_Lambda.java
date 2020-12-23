
package calculator_lambda;
import calculator_lambda.FunctionInterface.MyInterface;

public class Calculator_Lambda {

    public static void main(String[] args) {
        // TODO code application logic here
    
    MyInterface add = (x,y) -> {
        return (x+y);
                };  
			
    MyInterface minus = (x,y) -> {
        return (x-y);
                }; 
    
    MyInterface multiply = (x,y) -> {
        return (x*y);
                }; 
    
    MyInterface divide = (x,y) -> {
        return (x/y);
                }; 
    
    System.out.println("1 + 2 = : " + add.operation(1f, 2f) );
    System.out.println("5 - 4 = : " + minus.operation(5f, 4f) );
    System.out.println("8 x 3 = : " + multiply.operation(8f, 3f) );
    System.out.println("9 / 2 = : " + divide.operation(9f, 2f) );
    
    }
    
}
