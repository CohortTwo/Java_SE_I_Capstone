
package lambda;

import lambda.FunctionInterface.MyInterface;

public class Lambdafunction {
       public static void main(String[] args) {
			
		MyInterface myInterface = (x,y,z) -> {
	          System.out.print(x + " ");
                  return (y/z*100);
                };  
			
		System.out.println(myInterface.grading("Physics", 80, 200) + "%");
                System.out.println(myInterface.grading("Biology", 40, 50) + "%");
	}

}
