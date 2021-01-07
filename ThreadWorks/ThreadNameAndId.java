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
public class ThreadNameAndId extends Thread {

    @Override
    public void run() {
        System.out.println("running...");
    }

    public static void main(String args[]) {
        ThreadNameAndId t1 = new ThreadNameAndId();
        ThreadNameAndId t2 = new ThreadNameAndId();
        System.out.println("Name of t1:" + t1.getName());
        System.out.println("Name of t2:" + t2.getName());
        System.out.println("id of t1:" + t1.getId());

        t1.start();
        t2.start();

        t1.setName("MyThread");
        System.out.println("After changing name of t1: " + t1.getName());
    }
}
