
package logic;

import design.AccountTypes;

public class AccImp implements AccountTypes{
    
    public double savingAcc(int age){
        if (age >= 60){
            return 0.02;
        }
        else if (age >= 40 && age <=59){
            return 0.018;
        }
        else{
            return 0.015;
        }
    }
    
    public static void main(String[] args) {
        AccImp Acc1 = new AccImp();
        System.out.println(Acc1.currentAcc(10001));
        System.out.println(Acc1.currentAcc(5001));
        System.out.println(Acc1.savingAcc(64));
        System.out.println(Acc1.savingAcc(42));
        System.out.println(Acc1.savingAcc(10));
        System.out.println(AccountTypes.INTERBANKRATE);
    }
}
