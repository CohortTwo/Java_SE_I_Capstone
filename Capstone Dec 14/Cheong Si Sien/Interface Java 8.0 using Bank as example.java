package banking;

interface rate {
    double ELDERRATE = 10.0;
    
    void oldmethod(); // this is old type astract assumed 
    
    default void curAcct() {
        System.out.println("\033[0;34m" + "2% CA ==> Rate recommended by authority");
    }

    static void ElderAcct() {
        System.out.println("\033[0;34m" + ELDERRATE + "% Elderly ==> Rate COMPULSORY for Elderly ");
    }
}

class Banks {

    public static void main(String[] args) {
        DBS newDBS = new DBS();
        System.out.println("DBS Interest Rate");
        newDBS.curAcct();
        newDBS.oldmethod(10);
        newDBS.oldmethod(20);
        rate.ElderAcct();
        System.out.println("------------------------------------------------------");
        System.out.println();

        UOB newUOB = new UOB();
        System.out.println("UOB Interest Rate");
        newUOB.curAcct();
        newUOB.oldmethod();
        rate.ElderAcct();
        System.out.println("--------------------------------------------------------");
    }
}

class DBS implements rate {

    public void oldmethod(int age) {
    
        if (age <= 18) {
            System.out.println("\033[0;31m" + "0.9% SA ==> DBS implementing it's own rate for young ppl");
        } 
        else
            System.out.println("\033[0;31m" + "0.5% SA ==> DBS implementing it's own rate for adults");
    }

    @Override
    public void oldmethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class UOB implements rate {

    @Override
    public void oldmethod() {
        System.out.println("\033[0;31m" + "0.8% SA ==> UOB implementing it's own rate for ALL");
    }

    @Override
    public void curAcct() {
        System.out.println("\033[0;31m" + "1.5% CA ==> UOB implementing it's own rate for ALL");
          }
}
