package coursework;

public class Fibonacci {

    public static int fibonacciSequence(int num){
        if(num == 1){
            return 0;
        }
        if(num == 2){
            return 1;
        }
        return fibonacciSequence(num - 1) + fibonacciSequence(num - 2);
    }


    public static void main(String[] args) {
        for(int i = 1; i < 10; i++){
            System.out.println(fibonacciSequence(i));
        }
    }

}
