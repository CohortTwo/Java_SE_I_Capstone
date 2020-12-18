package bankapp;

public class MainClass {

    public static void main(String[] args) {
//        ISavAcc acc = new BankApp();
        BankApp acc = new BankApp();
        System.out.println("inetrafce abstract method : " + acc.abstractROI(1200f));
        System.out.println("interface default method : " + acc.defaultROI());
        System.out.println("interface static method : " + ISavAcc.staticROI(61));
        System.out.println("overriden interface default method, ICurAcc : " + acc.defaultCurROI());

//        ISavAcc acc1 = new BankApp1();
        ISavAcc acc1 = new BankApp1();
        System.out.println("\ninterface abstract method : " + acc1.abstractROI(1200f));
        System.out.println("overriden interface default method : " + acc1.defaultROI());
        System.out.println("interface static method : " + ISavAcc.staticROI(46));
        System.out.println("overriden interface default method, ICurAcc : " + ((BankApp1) acc1).defaultCurROI());
    }
}
