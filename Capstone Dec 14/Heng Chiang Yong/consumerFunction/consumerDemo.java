/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumerFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @author chiangyong
 */
public class consumerDemo {

    public static void main(String args[]) {

        //Consumer functional interface
        Consumer<Integer> cons = t -> System.out.println("Print Output : " + t);
        Consumer<String> printCons = p -> System.out.println(p);
        
        cons.accept(100);
        String consName[] = {"BMW","AUDI","VOLVO","MAZADA","NISSAN","TOYOTA","PORSCHE"};
        
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numList.stream().forEach(cons);
        
       System.out.println(Arrays.toString(consName));  //print the array
      
       for(int i = 0; i <consName.length;i++)           //using consumer
        {
        printCons.accept(consName[i]);
        }
        //Functional Interface with Lamda expression
//        Function<Integer, Integer> mul = x -> x * 2;
//        int result = mul.apply(4);
//        int res = mul.andThen(mul).apply(4);
//        int resc = mul.compose(mul).apply(4);
//        System.out.println("Apply Result is " + result + "\nandThen res is " + res
//                + "\nCompose resc is " + resc);
    }

}
