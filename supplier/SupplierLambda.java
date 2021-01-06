/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.supplier;

import java.util.function.Supplier;

/**
 *
 * @author sridh
 */
public class SupplierLambda {
     public static void main(String[] args) {
  
  Supplier<String> supplier= ()-> "Support for Lambda's";
  System.out.println(supplier.get());
 }
}
