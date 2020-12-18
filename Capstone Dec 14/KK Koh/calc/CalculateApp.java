package calc;

public class CalculateApp implements CalcInterface {

    @Override
    public float add(float val1, float val2) {
        return val1 + val2;
    }

    @Override
    public float minus(float val1, float val2) {
        return val1 - val2;
    }

    @Override
    public float multiply(float val1, float val2) {
        return val1 * val2;
    }

    @Override
    public float divide(float val1, float val2) {
        return val1 / val2;
    }

    public static void main(String[] args) {
        CalculateApp calc = new CalculateApp();
        System.out.println(" add(20.0f, 10.0f) = " + calc.add(20.0f, 10.0f));
        System.out.println(" minus(20.0f, 10.0f) = " + calc.minus(20.0f, 10.0f));
        System.out.println(" multiply(20.0f, 10.0f) = " + calc.multiply(20.0f, 10.0f));
        System.out.println(" divide(20.0f, 10.0f) = " + calc.divide(20.0f, 10.0f));
    }

}
