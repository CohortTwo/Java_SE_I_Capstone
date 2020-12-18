package bankapp;

interface ICurAcc {

    default float defaultCurROI() {
        return 0.03f;
    }
}
