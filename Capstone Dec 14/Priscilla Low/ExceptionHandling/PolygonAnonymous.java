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
abstract class Polygon {

    public void display() {
        System.out.println("Inside the Polygon class");
    }
}

public class PolygonAnonymous {

    public static void main(String[] args) {

        // creation of anonymous class extending class Polygon
        Polygon p1 = new Polygon() {
            public void display() {
                System.out.println("Inside an anonymous class.");
            }
        };
        p1.display();
    }
}
