/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadWorks;

/**
 *
 * @author sridh
 */
public class ThreadPriorityDemo extends Thread {
    // Java program to demonstrate getPriority() and  setPriority()

    public void run() {
        System.out.println("running thread's name is:" + Thread.currentThread().getName());
        System.out.println(" running thread's  priority is: " + Thread.currentThread().getPriority());

    }

    public static void main(String args[]) {
        ThreadPriorityDemo m1 = new ThreadPriorityDemo();
        ThreadPriorityDemo m2 = new ThreadPriorityDemo();
        ThreadPriorityDemo m3 = new ThreadPriorityDemo();
        m1.setPriority(Thread.MIN_PRIORITY);  //always set to 1
        m2.setPriority(Thread.MAX_PRIORITY); // always set to 10
        m3.setPriority(Thread.NORM_PRIORITY); // always set to 5
        m1.start();
        m2.start();
        m3.start();

    }
}
