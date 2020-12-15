/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import design.*;
/**
 *
 * @author sridh
 */
public class BuildVehicle implements TypeOfVehicle {

    /**
     *
     * @param seats
     */
    @Override
    public void type(int seats)
    {
        if(seats>5)
            System.out.println("Sedan");
        else if(seats<5)
            System.out.println("SUV");
        else
            System.out.println("Passenger");
    }
    
    /**
     *
     * @param ag
     */
    @Override
    public void autoGear(boolean ag)
{
    if (ag)
        System.out.println("Automatic Transmission");
    else
        System.out.println("Manual Transmission");
}

    /**
     *
     * @param c
     */
    @Override
    public void cruiseControl(boolean c)
{
    if (c)
        System.out.println("Superior model");
    else
        System.out.println("Entry Model");
}
    
    public static void main(String[] args)
    {
        BuildVehicle bv = new BuildVehicle();
        bv.autoGear(true);
        bv.cruiseControl(false);
        bv.type(7);
    }
}
