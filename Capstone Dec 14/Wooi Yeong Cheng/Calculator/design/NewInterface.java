package design;

public interface NewInterface {

    public void savingAc(int age);

    default float currentAc(float acBal) {
//        float rRate;
//        if (acBal == 10000) {
//            rRate = 0.025f;
//        } else {
//            rRate = 0.015f;
//        }
 //       System.out.println("Current Account rate = " );
//        return rRate;
        return acBal;
        
    }

    public static void interate() {
        float rRate = 0.05f;
        System.out.println("Interate is = " + rRate);
    }

}
