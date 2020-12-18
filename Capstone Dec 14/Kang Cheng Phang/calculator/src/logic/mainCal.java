/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import define.calculatorInput;

/**
 *
 * @author User
 */
public class mainCal {

    public static void displayHead() {
        System.out.println("-----------------------------------------------------");
    }
    
    public static void insertLine() {
        System.out.println(" ");
    }
    

    public static void main(String[] args) {
        calculatorFunc cal = new calculatorFunc();

        cal.add(5, 2, 1);
        cal.subtract(10, 4);
        cal.multiply(2, 4);
        cal.divide(9, 3);
        cal.modulus(6, 2);
        displayHead();
        System.out.println("When age is over 60,");
        cal.savingsAccRate(79);
        insertLine();
        System.out.println("When age is between 50 to 60,");
        cal.savingsAccRate(52);
        insertLine();
        System.out.println("When age is under 50,");
        cal.savingsAccRate(40);
        displayHead();
        System.out.println("When account balance is less than $10,000,");
        cal.currentAccRate(5000);
        insertLine();
        System.out.println("When account balance is more than $10,000,");
        cal.currentAccRate(12000);
        displayHead();
        calculatorInput.interbankRate();
        displayHead();
    }

}
