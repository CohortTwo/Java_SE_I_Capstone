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
public class ThreadRunnableExample implements Runnable {

    @Override
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String args[]) {
        ThreadRunnableExample m1 = new ThreadRunnableExample();
        Thread t1 = new Thread(m1);
        t1.start();
    }
}
