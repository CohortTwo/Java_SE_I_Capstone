/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

/**
 *
 * @author sridhar
 */
public interface NewInterface8 {

    int MYVAR = 10;  // This is public static final by default

    void theOld(); // This is public abstract by default.

    default void newType() {
        System.out.println("New addition in Java 8");
    }

    static void anotherNewType() {
        System.out.println("Another new addition in Java 8");
    }
}
