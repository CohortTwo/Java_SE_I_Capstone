
package sg.com.CSSBank;

public class StaticPracticeAccount {
    static int i = 10;
    String ahName;
    String NRIC;
    int accNo;
    float bal;

    public float chkBalance() {
        return bal;
    }

    public float deposit(float depAmt) {
        return bal += depAmt;
    }

    public float withdraw(float wdAmt) {
        return bal -= wdAmt;
    }

    public StaticPracticeAccount(int a, String n, String nr, float b) {

        accNo = a;
        NRIC = nr;
        ahName = n;
        bal = b;
    }

    public StaticPracticeAccount() {

    }

    public StaticPracticeAccount(String n, float b) {

        ahName = n;
        bal = b;
    }

    public static void main(String[] args) {
        System.out.println(" i =  " + i);

        StaticPracticeAccount a1 = new StaticPracticeAccount(1, "SXXXX333D", "PersonA", 1000.0f);
        System.out.println(" balance in the account " + a1.chkBalance());
        System.out.println(" withdraw 5000 $  ==== " + a1.withdraw(5000.00f));
        System.out.println(" balance in the account " + a1.chkBalance());
        System.out.println(" withdraw 100 $  ==== " + a1.withdraw(100.00f));
        System.out.println(" deposity 500 $ ===== " + a1.deposit(500.00f));

    }

}
