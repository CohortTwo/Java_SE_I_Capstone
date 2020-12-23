
package logic;

public class lamdaCal {
    
    public static void main(String[] args) {
        
        Cal addNumber = (a,b) -> a + b;
        Cal subNumber = (a,b) -> a - b;
        Cal mulNumber = (a,b) -> a * b;
        Cal divNumber = (a,b) -> a / b;
        System.out.println(""+addNumber.cal(10, 20));
        System.out.println(""+subNumber.cal(20, 10));
        System.out.println(""+mulNumber.cal(5, 10));
        System.out.println(""+divNumber.cal(50, 5));
    }
    
    
    
}
