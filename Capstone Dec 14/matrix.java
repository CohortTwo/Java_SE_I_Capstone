
package sapp;
import java.util.Scanner;

public class matrix {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int [][] twoDA = { {1,5,4,3,2}, {416,58,44,33,22}, {21,55,48,33,25}, {61,85,94,33,42}};
      
           
         for(int i = 0 ; i < twoDA.length; i++){
                System.out.print( " Dimension :: " + i + " ==>> ");
           int total = 0, min = 0 , max = 0;
                for (int j = 0; j< twoDA[i].length; j++){
                System.out.print( twoDA[i][j] + " ");
                total += twoDA[i][j];
                if(j == 0)
                    min = max = twoDA[i][j];
                else {
                    min = min < twoDA[i][j] ? min : twoDA[i][j];
                    max = max > twoDA[i][j] ? max : twoDA[i][j];
                }
            }
                System.out.print( " Total = " + total + ", Avg = " + (total/twoDA[i].length));
                System.out.print( ", Min  = " + min + ", Max = " + max);
                System.out.println( " ");
        }
    }

}
