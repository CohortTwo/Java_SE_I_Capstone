/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capp;

/**
 *
 * @author chiangyong
 */
public interface MathOperator {
    float sum(float num1, float num2);
    float sub(float num1, float num2);
    float div(float num1, float num2);
    float mult(float num1, float num2);
    int mod(int num1, int num2);
    
    default void display(){
        System.out.println("Default Display");
    }
    
    static void staticDisplay(){
        System.out.println("Static Display");
    }
}
