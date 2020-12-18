/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package define;

/**
 *
 * @author User
 */
public interface calculatorInput {

    float INTERBANKRATE = (float)0.05;
    
    public void savingsAccRate(int age);

    default float currentAccRate(float accBal) {
        float returnRate;
        if (accBal >= 10000) {
            returnRate = 0.025f;
        } else {
            returnRate = 0.015f;
        }
        System.out.println("The current account interest rate is: " + returnRate);
        return returnRate;
    }

    public static void interbankRate() {
        System.out.println("Interbank rate is " + INTERBANKRATE);
    }

    /**
     * @param a
     * @param b
     * @param c
     */
    public void add(int a, int b, int c);

    public void add(int a, int b);

    /**
     *
     * @param a
     * @param b
     */
    public void subtract(int a, int b);

    /**
     *
     * @param a
     * @param b
     */
    public void multiply(int a, int b);

    /**
     *
     * @param a
     * @param b
     */
    public void divide(int a, int b);

    /**
     *
     * @param a
     * @param b
     */
    public void modulus(int a, int b);

}
