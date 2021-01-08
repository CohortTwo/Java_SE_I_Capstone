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
public class mainThread {
    
    public static void main(String args[])
    {
//        int n = 8;  //number of threads
//        for( int i = 0; i < n; i++)
//        {
            ThreadDemo MyThread = new ThreadDemo();
          //  MyThread.start();   //Thread ID is 13 and Thread Name is Thread-0
            MyThread.run();      //Thread ID is 1 and Thread Name is main
//        }
        
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();
        ThreadDemo t3 = new ThreadDemo();
        
        //Default is 5
        System.out.println("t1 thread priority : " + t1.getPriority());
        System.out.println("t2 thread priority : " + t2.getPriority());
        System.out.println("t3 thread priority : " + t3.getPriority());
        
        t1.setPriority(3);
        t2.setPriority(7);
        t3.setPriority(10);
        
        System.out.println("t1 thread priority : " + t1.getPriority());
        System.out.println("t2 thread priority : " + t2.getPriority());
        System.out.println("t3 thread priority : " + t3.getPriority());
        
        System.out.println("Current Executing Thread : "
        + Thread.currentThread().getName()+ ", priority : "
        + Thread.currentThread().getPriority());
    }
}
