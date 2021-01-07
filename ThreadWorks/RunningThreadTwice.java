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
public class RunningThreadTwice extends Thread {

    @Override
    public void run() {
        System.out.println("running...");
    }

    public static void main(String args[]) {
        RunningThreadTwice t1 = new RunningThreadTwice();
        t1.start();
    t1.start(); // IllegalThreadStateException is thrown as the the thread is already running.
    }
}
