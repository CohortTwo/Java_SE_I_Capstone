/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumerFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author chiangyong
 */
public class supplierFunction {
    
    public static void main(String args[])
    {
//        Supplier<String> supplier = () -> {
//            return "Hi, I am supplier";
//        };
        Supplier<String> supplier = () -> "Hi, I am supplier";
       
     //   System.out.println(supplier.get());
        
      // List<String> prodList = Arrays.asList("apple","orange","durian","papaya","mango");
        List<String> prodList = Arrays.asList();
        
        System.out.println(prodList.stream().findAny().orElseGet(supplier));
    }
    
}
