/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadWorks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author sridh
 */
    class WorkerThread implements Runnable {

        private String message;

        public WorkerThread(String s) {
            this.message = s;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
            processmessage();
            System.out.println(Thread.currentThread().getName() + " (End)");
        }

        private void processmessage() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public class ThreadPoolExample {

        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 10; i++) {
                Runnable worker = new WorkerThread("" + i);
                executor.execute(worker);
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println("Finished all threads");
        }
    }
