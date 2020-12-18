import java.util.Scanner;

public class Palindrome {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		StringBuffer str = new StringBuffer("test");
		String result = "";

		for (int i = str.length()-1; i >= 0; i--) 
			result = result + str.charAt(i);

		System.out.println(result);

	}
}
