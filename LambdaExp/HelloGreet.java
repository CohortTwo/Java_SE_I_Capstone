/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaExp;

/**
 *
 * @author sridh
 */
public class HelloGreet {
    public void Greet(Greeting g)
    {
        g.perform();
  
    }
    
    public static void main(String[] args) {
//        HelloGreet gr = new HelloGreet();
//        HelloWorld hw = new HelloWorld();
//        gr.Greet(hw);
        
       // MyLambda MyLambdaFunction = () -> System.out.println("Hello World"); 
    Greeting MyLambdaFunction = () -> System.out.println("Hello World");
       MyLambdaFunction.perform();
    }
}
//interface MyLambda{
//void test();
//}