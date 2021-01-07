/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadWorks;

import java.util.Set;

/**
 *
 * @author sridh
 */
public class ListRunningThreads implements Runnable {

    public static void main(String[] args) {
        Runnable r = new ListRunningThreads();
        r.run();
//        Thread t1 = new Thread(r,"Temp Thread");
//        t1.start();
    }

    @Override
    public void run() {
       Set<Thread> threads = Thread.getAllStackTraces().keySet();
       
//       threads.stream()
//                      .forEach(System.out::println);

        for (Thread t : threads) {
            String name = t.getName();
            Thread.State state = t.getState();
            int priority = t.getPriority();
            String type = t.isDaemon() ? "Daemon" : "User";
            System.out.printf("%-16s \t %s \t %d \t %s\n", name, state, priority, type);
        }
    }
}

