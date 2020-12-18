package workshop_jshell;

public class factorial {

    static int factorials(int n) {
   if (n == 0)
       return 1;
   else
        return (n*factorials(n-1));}
    
    
    public static void main(String[] args) {
    int answer = factorials(6);
    System.out.println("factorial of 6 : answer = " + answer);
    }
}
    