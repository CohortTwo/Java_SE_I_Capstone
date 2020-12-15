/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import design.NewInterface8;
/**
 *
 * @author sridh
 */
public class NewInterface8Imp implements NewInterface8 {
    
    @Override
    public void theOld()
    {
        System.out.println("the is the traditional method override");
        
    }
        
     
    public static void main(String args[])
    {
        NewInterface8Imp ni = new NewInterface8Imp();
        ni.theOld();
        ni.newType();
        NewInterface8.anotherNewType();
        
    }
}
