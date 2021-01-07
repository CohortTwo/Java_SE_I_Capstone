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
class TableNew {

    synchronized void printTable(int n) {//synchronized method  
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("------------");

    }
}

class MyThread1 extends Thread {

    TableNew t;

    MyThread1(TableNew t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }

}

class MyThread2 extends Thread {

    TableNew t;

    MyThread2(TableNew t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(15);
    }
}

public class SynchronizationThreadExamle {

    public static void main(String args[]) {
        TableNew obj = new TableNew();//only one object  
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}
