/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplications;

import define.*;


/**
 *
 * @author sridharguzzu
 */
public class AutoDetail implements Vehicles {

    @Override
    public void car(int gears) {
        System.out.println("this is a car with " + gears + " gears"  );
    }

    @Override
    public void bike(int gears) {
        System.out.println("this is a bike with " + gears + " gears"  );
    }
    public static void main(String[] args) {
        
       AutoDetail Ad = new AutoDetail();
       Ad.car(5);
       Ad.bike(4);
                    
   }
           
}
