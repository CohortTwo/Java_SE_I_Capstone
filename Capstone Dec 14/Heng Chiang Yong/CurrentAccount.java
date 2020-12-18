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
public class CurrentAccount implements MainBank{
    
    public double IRateofReturn(int age, float balance){
        double interest = 0.003;
        return balance*interest;
    }
}
