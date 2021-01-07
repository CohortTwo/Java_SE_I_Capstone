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
public class ThreadDaemonExample extends Thread {
    public void run(){  
  if(Thread.currentThread().isDaemon()){//checking for daemon thread  
   System.out.println("daemon thread work");  
  }  
  else{  
  System.out.println("user thread work");  
 }  
 }  
 public static void main(String[] args){  
  ThreadDaemonExample t1=new ThreadDaemonExample();//creating thread  
  ThreadDaemonExample t2=new ThreadDaemonExample();  
  ThreadDaemonExample t3=new ThreadDaemonExample();  
  
  t1.setDaemon(true);//now t1 is daemon thread  (Should be marked before startng it).
    
  t1.start();//starting threads  
  t2.start();  
  t3.start();  
 }   
}
