
package logic;

import design.NewInterface;


public class NewClass implements NewInterface {

    @Override
    public void savingAc(int age) {
       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float currentAc(float acBal) {
        float rRate;
        if (acBal == 10000) {
            rRate = 0.025f;
        } else {
            rRate = 0.015f;
        }
        System.out.println("Current Account rate = " + rRate);
        return rRate;
       // return NewInterface.super.currentAc(acBal); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[]args){
        
        NewClass ba = new NewClass();
        
   //     System.out.println("void type cant access here = " + ba.savingAc(40));
        
        ba.savingAc(40);
        ba.currentAc(10000);
        NewInterface.interate();
        
    }
    
}
