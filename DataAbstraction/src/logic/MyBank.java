/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import design.RateOfInterest;

/**
 *
 * @author sridhar
 */
class MyBank extends RateOfInterest {

    @Override
    public void setInterest() {
        System.out.println("The RoI has been set to 9.88%");
    }

    @Override
    public float getInterest() {
                return 9.88f;
    }

    public static void main(String[] args) {
        MyBank mb = new MyBank();
        mb.setInterest();
        float f = mb.getInterest();
        System.out.println(f);
        
    }

}
