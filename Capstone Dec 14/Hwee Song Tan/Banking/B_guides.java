/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design;

/**
 *
 * @author andrew
 */
public interface B_guides {
    
    
    
    float theSavAcc(int age); //abstract
    
    default float theCurAcc(float amt){
    float rate;
    if (amt >= 10000) {
            rate = (float) 2.5;

        } else {
            rate = (float) 1.5;
        }
        return rate;
    }
    
    static float interbank(){
    return (float)0.5;
    }
    
    
    
    
    
}
