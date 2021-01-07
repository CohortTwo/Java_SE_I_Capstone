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
public class thread_example1 implements Runnable {

    @Override
    public void run() {
    }

    public static void main(String[] args) {
        Thread mythread1 = new Thread();
        Thread mythread2 = new Thread("mythread2");
        mythread1.setPriority(1);
        mythread1.setPriority(3);
        mythread1.start();
        mythread2.start();
        try {
            mythread1.sleep(100);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        mythread1.setPriority(1);
        int threadpriority = mythread1.getPriority();
        int threadpriority1 = mythread2.getPriority();
        System.out.println(mythread1.getName() + ", has a priority of  " + threadpriority + ". And " + mythread2.getName() + ", has a priority of   " + threadpriority1);
        System.out.println("Thread Running");
    }
}
