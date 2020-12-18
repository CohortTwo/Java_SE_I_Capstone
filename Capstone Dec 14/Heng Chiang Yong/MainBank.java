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
public interface MainBank {
    
    static double IRateOfReturn(int age, float balance){
        double interest = 0.00010;
        return balance * interest;
        
    }
    
    default double IReturnOfInterest(int age, float balance){
        double interest = 0.05;
        
        return balance * interest;
        
    }
}
