/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.consumer;

import java.util.function.Consumer;

/**
 *
 * @author sridh
 */
public class ConsumerExample {
     public static void main(String[] args) {
  
  Consumer<String> consumerString=s->System.out.println(s);
  consumerString.accept("Hello");
 }
}
