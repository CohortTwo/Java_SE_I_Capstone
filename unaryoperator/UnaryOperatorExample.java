/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.unaryoperator;

import java.util.function.UnaryOperator;

/**
 *
 * @author sridh
 */
public class UnaryOperatorExample {

         public static void main(String[] args) {
            UnaryOperator<Integer> operator = t -> t * 2;   // lambda expression
            System.out.println(operator.apply(5));
            System.out.println(operator.apply(7));
            System.out.println(operator.apply(12));
        }
    }

