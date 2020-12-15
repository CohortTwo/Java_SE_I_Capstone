/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import design.Vehicles;

/**
 *
 * @author sridh
 */
public class AutoDetail implements Vehicles {

    /**
     *
     * @param gears
     */
    @Override
    public void bike(int gears) {
        System.out.println("Bike with " + gears + " Gears");
    }

    @Override
    public void car(int gears) {
        System.out.println("Car with " + gears + " Gears");
    }

    public static void main(String[] args) {
        AutoDetail ad = new AutoDetail();
        ad.bike(4);
        ad.car(6);
    }
}
