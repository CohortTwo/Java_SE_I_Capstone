/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LambdaExp;

/**
 *
 * @author sridh
 */
interface StringFunction {

    String run(String str);
}

public class LambdaExpParam {

    public static void main(String[] args) {
        StringFunction exclaim = a -> a + "!";
        StringFunction ask = s -> s + "?";
        printFormatted("Hello", exclaim);
        printFormatted("Hello", ask);
//        //System.out.println(exclaim.run("Simon"));
//        //System.out.println(exclaim( "Test Function"));
//    }
//        static String exclaim(String s1)
//        {
//            s1=s1+"!";
//            return s1;
//            StringFunction sf = new StringFunction(String  {}s) {
//        
//        String run(String str){return str;}
//    
      }

    // Create a method which takes a lambda expression as a parameter:
    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
    }
}
