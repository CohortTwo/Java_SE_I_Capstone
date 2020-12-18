package bankapp;

public class BankApp implements ISavAcc, ICurAcc {

    @Override
    public float abstractROI(float bal) {
        if (bal > 100f) {
            return 0.02f;
        }
        if (bal > 1000f) {
            return 0.03f;
        }
        return 0.01f;
    }

}
