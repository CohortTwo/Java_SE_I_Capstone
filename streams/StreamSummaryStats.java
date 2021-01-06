/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 *
 * @author sridh
 */
public class StreamSummaryStats {
    public static void main(String[] args) {
        // Creating an IntStream 
        IntStream stream = IntStream.of(7894, 3335, 336, 2567,88,98,887,666); 
  
        // Using IntStream summaryStatistics() 
        IntSummaryStatistics summary_data =  
                        stream.summaryStatistics(); 
  
        // Displaying the various summary data 
        // about the elements of the stream 
        System.out.println(summary_data); 
    }
}
