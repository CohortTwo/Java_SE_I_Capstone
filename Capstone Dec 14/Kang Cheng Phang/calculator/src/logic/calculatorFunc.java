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
public class calculatorFunc implements calculatorInput {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void add(int a, int b) {
        this.value = a + b;
        System.out.println("Add " + a + " to " + b + " = " + this.value);
    }

    @Override
    public void add(int a, int b, int c) {
        this.value = a + b + c;
        System.out.println("Add " + a + " to " + b + " to " + c + " = " + this.value);
    }

    @Override
    public void subtract(int a, int b) {
        this.value = a - b;
        System.out.println("Subtract " + a + " from " + b + " = " + this.value);
    }

    @Override
    public void multiply(int a, int b) {
        this.value = a * b;
        System.out.println("Multiply " + a + " into " + b + " = " + this.value);
    }

    @Override
    public void divide(int a, int b) {
        this.value = a / b;
        System.out.println("Divide " + a + " by " + b + " = " + this.value);
    }

    @Override
    public void modulus(int a, int b) {
        this.value = a % b;
        System.out.println("Modulus " + a + " from " + b + " = " + this.value);
    }

    @Override
    public void savingsAccRate(int age) {
        float returnRate;
        if (age >= 60) {
            returnRate = 0.02f;
        } else if (age >= 50 && age <= 59) {
            returnRate = 0.018f;
        } else {
            returnRate = 0.015f;
        }
        System.out.println("The saving account interest rate is: " + returnRate);
    }

}
