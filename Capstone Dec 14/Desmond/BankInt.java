/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

/**
 *
 * @author Desmond
 */
public interface BankInt {

    //savings account rate
    float savings(float Amount, float IntAmt);

    //current account rate
    default float current(float Amount, float IntAmt) {
        if (Amount > 10000) {
            IntAmt = Amount * 0.025f;
            System.out.println("Current interest is 2.5% " + IntAmt);
            return IntAmt;
        } else {
            IntAmt = Amount * 0.015f;
            System.out.println("Current interest is 1.5% " + IntAmt);
            return IntAmt;
        }

    }

    //interbank rate
    static float inter(float Amount, float IntAmt) {
        IntAmt = Amount * 0.05f;
        System.out.println("Interbank rate is 5% " + Amount);
        return IntAmt;
    }

    public static void main(String[] args) {

    }

}
