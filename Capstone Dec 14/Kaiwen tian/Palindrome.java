package coursework;

public class Palindrome {


    public static boolean isPalindrome(String s){
        for(int i = 0 ; i < s.length()/2 ; i++){
            if(s.toLowerCase().charAt(i) != s.charAt(s.toLowerCase().length()-i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "Maam";
        System.out.println(isPalindrome(s));

    }


}
