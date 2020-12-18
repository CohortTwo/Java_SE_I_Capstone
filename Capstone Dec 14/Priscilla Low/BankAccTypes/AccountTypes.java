package design;

public interface AccountTypes {
    
    double savingAcc(int age);
    
    default double currentAcc(double balance) {
        if (balance > 10000) {
            return 0.025;
        } else {
            return 0.015;
        }

    }

    double INTERBANKRATE = 0.05; //public static final
    
}



//Can also write a method.
//public static void interbankRate() {
//        float returnRate = 0.05f;
//        System.out.println("Interbank rate is currently at: " + returnRate);
//    }
