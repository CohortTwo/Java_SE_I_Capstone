/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

/**
 *
 * @author chiangyong
 */
public class MainApp {
    
    
    public static void main(String args[]){
        
        SavingAccount sA = new SavingAccount();
        CurrentAccount cA = new CurrentAccount();
        
        System.out.println("SA return amount: " + sA.IReturnOfInterest(35, 10000.00f));
        System.out.println("Current Account amount: " + cA.IRateofReturn(60, 1000.00f));
        System.out.println("Main Bank account amount: " +MainBank.IRateOfReturn(40, 1000f));
    }
}
