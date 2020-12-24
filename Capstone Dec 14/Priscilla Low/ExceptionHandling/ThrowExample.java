/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

import java.io.IOException;

/**
 *
 * @author blueg
 */
public class ThrowExample {
    void myMethod(int number) throws IOException, ClassNotFoundException{
        if(number==1){
            throw new IOException("IOException occurred");
        }else if (number ==2){
            throw new ClassNotFoundException("ClassNotFoundException");
        }else{
            throw new NullPointerException("NullPointerException");
        }
    }
    
    public static void main(String[] args) {
        try{
            ThrowExample object = new ThrowExample();
            object.myMethod(10);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.println("sure gets printed");
        }
    }
}
