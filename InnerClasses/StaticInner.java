/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InnerClasses;

/**
 *
 * @author sridh
 */
public class StaticInner {

    int x = 10;

    static class Nested_Demo {

        public void my_method() {
            System.out.println("This is my nested class");
//            System.out.println(x);  // not allowed to access x...
        }
    }

    public static void main(String args[]) {
        StaticInner.Nested_Demo nested = new StaticInner.Nested_Demo();
        nested.my_method();

    }
}
