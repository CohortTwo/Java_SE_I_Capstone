/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

/**
 *
 * @author blueg
 */
abstract class Outer{
    public abstract void display();
}

public class InnerAnonymous {
    
    public static void main(String[] args) {
        Outer in = new Outer(){
            public void display(){
                System.out.println("Example of an anonymous inner class");
            }
        };
        
        in.display();
                
    }
}
