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
class OuterClass {

    static int x = 10;

    class InnerClass {

        public int myInnerMethod() {
            return x;
            
        }
    }
}

public class InnerAccessOuter {

    public static void main(String[] args) {
        OuterClass myOuter = new OuterClass();
        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        
        System.out.println(myInner.myInnerMethod());
    }
}
