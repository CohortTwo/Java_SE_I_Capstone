/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colonoperatorexamples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sridh
 */
// Java code to show use of double colon operator for instance method 
class Test {

    String str = null;

    Test(String s) {
        this.str = s;
    }

    // instance Method to be called  (the same applies to a static method also.
    void someMethod() {
        System.out.println(this.str);
    }
}

public class TestColoInstanceMethod {

    public static void main(String[] args) {

        List<Test> list = new ArrayList<Test>();
        list.add(new Test("This is accessed "));
        list.add(new Test("from"));
        list.add(new Test("an instance method"));

        // call the instance method  
        // using double colon operator  
        list.forEach(Test::someMethod);
    }
}
