/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

/**
 *
 * @author sridh
 */
public class NpException {
     public static void main(String[] args) {
      String ref = null;
      try{
      ref.toString(); // this will throw a NullPointerException
     System.out.println("try block");
      }catch(NullPointerException ne) { System.out.println("ref is not initialized");}
      finally {
          System.out.println("the rest of the program");
          ref="Now ref has been Initialized";
          System.out.println(ref);
      }
              
      }
   }
    
    
