/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author sridh
 */
// importing the File class

class FilesCreate {
  public static void main(String[] args) {

    // create a file object for the current location
    File file = new File("myfirst.txt");

    try {

      // trying to create a file based on the object
      boolean value = file.createNewFile(); 
      if (value) {
        System.out.println("The new file is created.");
      }
      else {
        System.out.println("The file already exists.");
      }
    }
    catch(IOException e) {
      e.getStackTrace();
    }
  }
}
