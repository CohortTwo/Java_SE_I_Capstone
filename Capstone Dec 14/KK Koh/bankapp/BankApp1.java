package bankapp;

public class BankApp1 implements ISavAcc, ICurAcc {

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

    @Override
    public float defaultROI() {
        return 0.02f;
    }

    @Override
    public float defaultCurROI() {
        return 0.15f;
    }

}
