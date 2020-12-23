/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;
 import java.io.FileWriter;
/**
 *
 * @author sridh
 */
public class FileWrite {
   

   public static void main(String args[]) {

     String data = "This is the data in the output file, Testing if thi is correct";
     try {
       // Creates a Writer using FileWriter
       FileWriter output = new FileWriter("myfirst.txt");

       // Writes string to the file
       output.write(data);
       System.out.println("Data is written to the file.");

       // Closes the writer
       output.close();
     }
     catch (Exception e) {
       e.getStackTrace();
     }
  }
}
