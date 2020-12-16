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
public class UsrDefineExeption {

    public static void main(String args[]) {
        try {
            // -----Throw an object of user defined exception 
            throw new MyException("My defined Exception");
        } catch (MyException me) {
            System.out.println(me);
        }
    }
}
