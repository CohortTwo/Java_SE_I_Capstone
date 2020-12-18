/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicFunctions;

import design.BankInt;
import java.util.Scanner;

/**
 *
 * @author Desmond
 */
public class Bank1 implements BankInt {

    public static Scanner sc = new Scanner(System.in);
    private static String CustName;
    private static int CustAge;
    private static String acType;
    private static float Amount;
    private static float IntAmt;

    public Bank1(String cn, int ca, String at, float amt) {
        this.CustName = cn;
        this.CustAge = ca;
        this.acType = at;
        this.Amount = amt;
    }

    @Override
    public float current(float Amount, float IntAmt) {
        return BankInt.super.current(Amount, IntAmt);
    }

    @Override
    public float savings(float Amount, float IntAmt) {
        if (CustAge < 20) {
            IntAmt = Amount * 0.05f;
            System.out.println("Interest of 5%... " + "$" + IntAmt);
            return IntAmt;
        } else if (CustAge > 50) {
            IntAmt = Amount * 0.15f;
            System.out.println("Interest of 15%..." + "$" + IntAmt);
            return IntAmt;
        } else {
            IntAmt = Amount * 0.1f;
            System.out.println("Interest of 10%..." + "$" + IntAmt);
            return IntAmt;
        }

    }

    public static void main(String[] args) {
        
        
        System.out.println("Please enter your name : ");
        CustName = sc.nextLine();
        System.out.println("Please enter your age : ");
        CustAge = sc.nextInt();
        System.out.println("Please enter account type : ");
        acType = sc.next();
        System.out.println("Please enter amount to deposit : ");
        Amount = sc.nextFloat();

        Bank1 newCust1 = new Bank1(CustName, CustAge, acType, Amount);

        if (acType.equalsIgnoreCase("savings")) {
            IntAmt = newCust1.savings(Amount, IntAmt);
        } else if (acType.equalsIgnoreCase("current")) {
            IntAmt = newCust1.current(Amount, IntAmt);
        } else {
            IntAmt = BankInt.inter(Amount, IntAmt);
        }
        System.out.println(newCust1);

    }

    @Override
    public String toString() {
        return "\nName: " + CustName.toUpperCase() + "\n"
                + "Age :" + CustAge + "\n"
                + "Account Type: " + acType.toUpperCase() + "\n"
                + "Amount Deposited: $" + Amount+ "\n"
                + "Interest Amount: $" + IntAmt;
    }

}
