/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myThread;

/**
 *
 * @author chiangyong
 */
public class ThreadDemo extends Thread{
    
    public void run()
    {
        try
        {
            System.out.println("Thread ID : "+
                    Thread.currentThread().getId()+
                    " is running, the current Thread Name = "+Thread.currentThread().getName());
        }
        catch(Exception e)
        {
            System.err.println("Exception is caught");
        }
    }
}
