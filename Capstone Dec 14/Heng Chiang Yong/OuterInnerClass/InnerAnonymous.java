/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OuterInner;

/**
 *
 * @author chiangyong
 */
abstract class Outer {
    
    public abstract void display(String s);
    public abstract float area(int a, int b);
    
}

public class InnerAnonymous {

    public static void main(String args[]) {
        Outer in = new Outer() {
            @Override
            public void display(String s) {
                System.out.println("Example of Inner Anonymous");
                System.out.println(s);
            }

            @Override
            public float area(int length, int base) {
                
               // System.out.println("Area = " + length * base);
                
                return length*base;
            }

//            @Override
//            public float area() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
        };
        
        in.display("This is Inner Anonymous example");
        System.out.println("Aread of 10 by 5 = " + in.area(10,5));
      //  in.area(11,2);
    }

}
