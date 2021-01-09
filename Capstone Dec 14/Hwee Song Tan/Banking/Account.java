/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.ocbc;

/**
 *
 * @author andrew
 */
public class Account {
    
    static int i = 10;
     String ahName;
     int aNo;
     float bal;
    
    public  float chkBalance(){
        return bal;
    }
    
    public  float deposit(float depAmt){
        return bal += depAmt;
    }
    
    public  float withdraw(float wdAmt){
        return bal -= wdAmt;
    }
    
    public Account(int a, String n, float b){
    
        aNo = a;
        ahName = n;
        bal = b;
    }
    public Account(){
    
    }
    public Account( String n, float b){
    
        ahName = n;
        bal = b;
    }
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(" i =  " + i);
        
        Account a1 = new Account(1,"Andrew Tan", 1_000_000.90f);
        
        System.out.println(" Account Holder's Name  " + a1.ahName);
        System.out.println(" balance in the account " + a1.chkBalance());
        System.out.println(" withdraw 5000 $  ==== " + a1.withdraw(10000.00f));
        System.out.println(" balance in the account " + a1.chkBalance());
        System.out.println(" withdraw 100 $  ==== " + a1.withdraw(100.00f));
        System.out.println(" deposity 500 $ ===== " + a1.deposit(500.00f));
    }
    
}