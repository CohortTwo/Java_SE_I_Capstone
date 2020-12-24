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
public class UserDefineException {
    
    static void validation(int value) throws MyException{
        if(value < 20 || value >100)
        {
            throw new MyException("value is not valid");
        }
        else{
            System.out.println("welcome, the value is OK.");
        }
            
    }
    
    public static void main(String[] args) {
        try{
            validation(52);
        }catch (MyException myexp){
            System.out.println("value is not valid, try again");
        }
    }
}
