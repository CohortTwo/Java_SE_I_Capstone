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
public class UnaryAndThenVsCompose {

    public static void main(String[] args) {
        UnaryOperator<Integer> add = t -> t + 5;
        UnaryOperator<Integer> multiply = t -> t * 5;
        // Using andThen() method
        int a = add.andThen(multiply).apply(5);
        System.out.println(a);
        // Using compose() method
        int b = add.compose(multiply).apply(5);
        System.out.println(b);
    }
}
