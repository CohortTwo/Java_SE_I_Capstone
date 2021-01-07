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
public class ThreadJoinExample extends Thread {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        ThreadJoinExample t1 = new ThreadJoinExample();
        ThreadJoinExample t2 = new ThreadJoinExample();
        ThreadJoinExample t3 = new ThreadJoinExample();
        t1.start();
        try {
            t1.join();  // will cause t2 and t3 to wait untill t1 is completed 
        } catch (Exception e) {
            System.out.println(e);
        }

        t2.start();
        t3.start();
    }
}
