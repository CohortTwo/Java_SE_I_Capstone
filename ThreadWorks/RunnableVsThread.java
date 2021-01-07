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
class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable interface");
    }
}

class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("Thread class ");
    }
}

class RunnableVsThreadDemo {

    public static void main(String[] args) {
        new ThreadDemo().start();
        new Task().run();
//        new Thread(new Task()).start();

    }
}
