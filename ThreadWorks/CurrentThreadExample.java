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
public class CurrentThreadExample extends Thread {

    @Override
    public void run() {
        System.out.println("Hello World");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());
    }

    public static void main(String args[]) {
        CurrentThreadExample t1 = new CurrentThreadExample();
        CurrentThreadExample t2 = new CurrentThreadExample();

        t1.start();
        t2.start();
        
    }
}
