/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set;
import java.util.ArrayList;
/**
 *
 * @author Karishma
 */
public class breakcontinue {

    /**
     * @param args the command line arguments
     */
   
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
			if ((Integer)i == 3) {
				System.out.println("Continue statement ran on encountering the integer 3");
				continue;
                        }
        }
    }
}

                        

		
	

    

