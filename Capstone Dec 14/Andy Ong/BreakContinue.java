package andy;

import java.util.ArrayList;

public class BreakContinue {

	public static ArrayList<Integer> genSeq(int len)  {
		ArrayList<Integer> value = new ArrayList<>();
		int i = 0; 
		while (i <= len) {
			value.add(i);
			i++;
		}
		return value;
	}

    public static void main(String[] args) {
        for (Object i : genSeq(10).toArray()) {
			System.out.println((Integer)i);
			if ((Integer)i == 6) {
				System.out.println("Continue statement ran on encountering the integer 6");
				continue;
			}
		}
	}
}
