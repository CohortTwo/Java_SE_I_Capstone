package Functions;

import java.util.function.Function;
import java.util.Random;

public class ApplyAndThenComposeIdentity {


    public static void main(String[] args) {


        Random somenum = new Random();
        int x = somenum.nextInt(100); // Generating a random number between 1 and 100.

        Function<Integer, Double> calculate = a -> a * 3.0;
        Function<Integer, Integer> id = Function.identity();

        System.out.println("The random number generated is " + id.apply(x));
        System.out.println("First calculation is " + calculate.apply(x));

        calculate = calculate.andThen(a -> a / 2.0);

        System.out.println("Second calculation is " + calculate.apply(x));

        Function<Integer, Double> calculateDiv = a -> a / 2.0;
        Function<Integer, Double> calculateAdd = a -> a + 9.0;
        Function<Integer, Double> calculateDivAdd = calculateDiv.andThen(calculateAdd);
        Function<Integer, Double> calculateAddDiv = calculateDiv.compose(calculateAdd);

        double resultOfAndThen = calculateDivAdd.apply(x);
        double resultOfCompose = calculateAddDiv.apply(x);

        System.out.println("The first method of x / 2 + 9 yields " + resultOfAndThen);
        System.out.println("The second method of (x + 9) / 2 yields " + resultOfCompose);



    }

}
