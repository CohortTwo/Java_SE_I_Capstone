import java.util.Scanner;

public class BankAccount implements InterestsRates {

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		BankAccount userAccount = new BankAccount();
		System.out.println(
				"Saving Account interest: " + userAccount.savInterestRates(18));
		System.out.println(
				"Current Account interest: " + userAccount.cur(12000));
		System.out.println("SIBOR rate: " + INTERBANK_RATE);
	}
	@Override
	public float savInterestRates(int age) {
		return (age < 10) ? 0.01f : 0.02f;
	}
}


interface InterestsRates {
	final static float INTERBANK_RATE = 0.05f;

	public float savInterestRates(int age);

	default public float currInterestRates(float bal) {
		return (bal >= 10000) ? 0.025f : 0.015f; 
	}
}
