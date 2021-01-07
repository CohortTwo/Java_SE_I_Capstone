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
public class TestColonConstructor {
    // Class constructor 

    public TestColonConstructor(String s) {
        System.out.println("Hello " + s + " !");
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("Simon");
        list.add("Andrew");
        list.add("John");

        // call the class constructor using double colon operator 
        list.forEach(TestColonConstructor::new);

//                The TestColonConstructor::new replaces the code below.
//                for(int i=0;i<list.size();i++)
//                {
//                    TestColonConstructor tcs = new TestColonConstructor(list.get(i)));
//                }
    }
}
