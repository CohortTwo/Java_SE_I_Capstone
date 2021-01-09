/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrew
 */
public class revStr {

    /**
     * @param args the command line arguments
     */
      public static String revStr(String a) {
        String s1 = a;
        String temp = "";

        for (int i = s1.length(); i > 0; i--) {
            temp = temp + s1.charAt(i - 1);
        }
        return temp;
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
    String results;
    
    
    results = revStr("love");
    System.out.println(results);
    
    results = revStr("dinner");
    System.out.println(results);
    
    

}
    
}
