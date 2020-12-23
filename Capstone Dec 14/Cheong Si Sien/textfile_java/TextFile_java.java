
package textfile_java;
import java.io.BufferedWriter;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class TextFile_java {
 
  public static void main(String[] args) {
    try {
         File newFile = new File("Z:cheongss.txt");
         if (newFile.createNewFile()) {
             System.out.println("File created, continue to write content: " + newFile.getName());
         } 
         else {
         System.out.println("File already exists, will proceed to append content.");
         }
          FileWriter fr = new FileWriter(newFile, true);
          BufferedWriter br = new BufferedWriter(fr);
          br.write("\ntesting\n");
          br.close();
          fr.close();
    }    
    
    catch (IOException e) {
      System.out.println("An error occurred: " +e.getMessage());
      //printStackTrace();
    }

  }
}



    