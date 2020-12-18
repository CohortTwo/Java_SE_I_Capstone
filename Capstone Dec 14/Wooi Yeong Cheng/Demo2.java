package demo;

public class Demo2 {

    public static void main(String args[]) {
        int a = 0;
        int b = 1;
        int c;
        int count = 1;
        System.out.print(" " + a + " " + b + " ");
        while (count < 10) {
            System.out.print(a + b + " ");
            c = a + b;
            a = b;
            b = c;
            count++;
        }
    }
}
