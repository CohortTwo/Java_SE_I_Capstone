/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author sridh
 */
// importing the FileReader class
import java.io.FileReader;
import java.io.IOException;

class Main {

    public static void main(String[] args) {

        char[] array = new char[100];
        try {
            // Reads characters
            try ( // Creates a reader using the FileReader
                    FileReader input = new FileReader("myfirst.txt")) {
                // Reads characters
                input.read(array);
                System.out.println("Data in the file:");
                System.out.println(array);
                // Closes the reader
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
