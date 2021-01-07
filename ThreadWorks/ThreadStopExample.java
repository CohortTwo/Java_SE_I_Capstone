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
public class ThreadStopExample {

    public static class StopThread implements Runnable {

        private boolean stopRequested = false;

        public synchronized void requestStop() {
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested() {
            return this.stopRequested;
        }

        private void sleep(long duration) {
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
                System.out.println("StopRunable is running");
                while(!isStopRequested())
                {
                    sleep(1000);
                    System.out.println("...");
                }
        System.out.println("StopeRunnable has been stopped");        
        }
    }
    public static void main(String[] args) {
        StopThread sr = new StopThread();
        Thread thread = new Thread(sr, "My Thread");
        thread.start();
        
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
                e.printStackTrace();
        }
        System.out.println("Requesting to stop the Thread, StopRunnable");
        sr.requestStop();
        System.out.println("Stop has been requested");
        
    }

}
