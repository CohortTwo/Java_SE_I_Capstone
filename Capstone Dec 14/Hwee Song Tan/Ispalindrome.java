/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andrew
 */
public class Ispalindrome {

    /**
     * @param args the command line arguments
     */
    
    public static boolean Ispalind(String a) {
           String s1 = a;
           String temp ="";
   
        for (int i = s1.length(); i > 0; i--) {
            temp = temp + s1.charAt(i - 1);
        }
        int j=0;
        for (int i = 0; i < s1.length(); i++) {
            if (temp.charAt(j)!=s1.charAt(i)){
            return false;
            }
            j++;
            }
        return true;
        }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    boolean test;
    
    
    test = Ispalind("hello");
    System.out.println(test);
    
    test = Ispalind("level");
    System.out.println(test);
    
    

}
    
}
