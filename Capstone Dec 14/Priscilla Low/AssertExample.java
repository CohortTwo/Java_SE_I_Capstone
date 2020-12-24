public class AssertExample {
    
    public static void main(String[] args) {
        int value = 2;
        assert value > 20 : "Underweight";
        System.out.println("value is " +value);
    }
}