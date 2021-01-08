/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author chiangyong
 */
public class StreamNumber {
    
    public static void main(String args[])
    {
        
        Random randNum = new Random();
        int getRandom = randNum.nextInt(10);
        int[] num = {9,2,5,7,4,2,7,0,8,3,2,5,1,6,10};
        
        int[] clone = Arrays.copyOf(num,num.length);  //clone the num arrays
        
        List<Integer> numbers = new ArrayList<Integer>();
        
                 
         IntStream.of(clone)
                 .distinct()                    //remove repeated numbers
                 .sorted()                      //sort in ascending order
                 .limit(5)                      //limit to 5
                 .forEach(System.out::println);  //print each output with limit of 5
         
         int sumOfClone = IntStream.of(clone)
               //  .sorted()
                 .skip(getRandom)                //do a skip with random number
                 .sum();
         
         System.out.println("Sum of Clone is "+sumOfClone);
        
         int[] numlist = IntStream.range(1,101).toArray();
                 
         int sumOfnumlist = IntStream.of(numlist).sum();
         
         System.out.println("Sum of numlist is " + sumOfnumlist);
         
         System.out.println("Summary Statistics : " + IntStream.of(numlist).summaryStatistics());
                 
               
    }
}
