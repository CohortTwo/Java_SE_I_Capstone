/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

/**
 *
 * @author blueg
 */
public class AssertExample {
    
    public static void main(String[] args) {
        int age = 60;
        assert age < 10 : "age "+age+" is high";

    }
}
