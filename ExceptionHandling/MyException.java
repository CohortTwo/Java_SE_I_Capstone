/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

/**
 *
 * @author sridhar
 */
public class MyException extends Exception {

    public MyException(String s) {
        // Call constructor of parent Exception 
        super(s);
    }
}
