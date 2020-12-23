
package lambda;

import lambda.FunctionInterface.MyInterface;

public class Lambdafunction {
       public static void main(String[] args) {
			
		MyInterface myInterface = (x,y,z) -> {
	          System.out.println(x + (y/z * 100));
                };  
			
		myInterface.grading("Physics %: ", 80f, 200);
                myInterface.grading("Biology %: ", 40f, 50);
		
	}

}
