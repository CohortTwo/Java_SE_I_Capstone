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

interface Age 
{ 
    int x = 21; 
    void getAge(); 
} 

public class AnonymousDemo {
        // inner class of Age interface'a Implementation 
        // whose name is not written but an object to it  
        // is created. 
        Age oj1 = new Age() { 
            @Override
            public void getAge() { 
                 // printing  age 
                System.out.print("Age is "+x); 
            } 
        }; 
        oj1.getAge(); 
    } 
} 
}
