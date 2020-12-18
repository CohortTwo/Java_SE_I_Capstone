package bankapp;

interface ISavAcc {

    float abstractROI(float bal);

    static float staticROI(int age) {

        if (age >= 60) {
            return 0.1f;
        } else {
            return 0.0f;
        }
    }

    default float defaultROI() {
        return 0.03f;
    }
}
