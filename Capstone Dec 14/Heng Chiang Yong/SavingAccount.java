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
public class SavingAccount implements MainBank{
    
    public double IReturnOfInterest(int age, float balance){
        double interest = 0.001;
        
        if(age >= 60)
            interest = 0.025;
        
        return balance * interest;
                
    }
    
}
