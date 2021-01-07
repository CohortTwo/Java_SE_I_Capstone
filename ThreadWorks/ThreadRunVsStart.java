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
public class ThreadRunVsStart extends Thread {

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }

    public static void main(String args[]) {
        ThreadRunVsStart t1 = new ThreadRunVsStart();
        ThreadRunVsStart t2 = new ThreadRunVsStart();

        t1.start(); // enable these two lines and see the difference of context switching
        t2.start();

            t1.run();
            t2.run();
    }
}
