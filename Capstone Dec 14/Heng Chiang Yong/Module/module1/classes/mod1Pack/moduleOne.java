/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mod1Pack;
import mod2Pack.moduleTwo;
/**
 *
 * @author chiangyong
 */
public class moduleOne {
    public static String welcomeMessage()
    {
        return "Welcome to Module One!";
    }
    
    public static void main(String args[])
    {
        System.out.println(new moduleOne().getClass().getModule());
        System.out.println(moduleOne.welcomeMessage());
        System.out.println(new moduleTwo().getClass().getModule());
        System.out.println(moduleTwo.welcomeMessage());
    }
}
