/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;
import java.util.function.Function;

/**
 *
 * @author chiangyong
 */
public class FunctionApply {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String str = "This is Compose";
        
        Function<String,Integer> fn = x -> x.length();
        Function<Integer,Integer> mulBy2 = x -> x*2;
        Function<Integer,Integer> addNum = x -> x+7;
        
        Function<Integer,Integer> addCompose = addNum.compose(mulBy2);
        
        Integer apply = fn.apply("Hello World!");
        System.out.println("Length of Hello World! is "+apply);
        
        Integer xLen = fn.apply("This is andThen");
        Integer result = fn.andThen(mulBy2).apply("This is andThen");
        System.out.println("Length of 'This is andThen'is "+xLen+" and multiply by 2 = " + result);
        
        Integer comR;
        comR = addCompose.apply(result);
        System.out.println("addCompose is " + comR);
        
    }
    
}
