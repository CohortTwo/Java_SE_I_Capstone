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
public class ThreadSleepExample extends Thread {

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i+ Thread.currentThread().getName());
        }
    }

    public static void main(String args[]) {
        ThreadSleepExample t1 = new ThreadSleepExample();
        ThreadSleepExample t2 = new ThreadSleepExample();

        t1.start();
        t2.start();
    }
    //If you put a thread to sleep for the specified time,the thread sheduler picks up another thread and so on.
}
