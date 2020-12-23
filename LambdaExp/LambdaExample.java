/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaExp;

import java.util.ArrayList;

/**
 *
 * @author sridh
 */
interface addInterface {

    int add(int a, int b);
}

public class LambdaExample {

    public static void main(String[] args) {
//    ArrayList<Integer> numbers = new ArrayList<Integer>();
//    numbers.add(5);
//    numbers.add(9);
//    numbers.add(8);
//    numbers.add(1);
//    numbers.forEach( (n) -> { System.out.println(n); } );

        addInterface addNums = (a, b) -> a + b;
        System.out.println(addNums.add(10, 20));
    }
    }

 