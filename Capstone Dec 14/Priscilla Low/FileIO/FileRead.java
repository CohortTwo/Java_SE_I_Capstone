/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIO;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author blueg
 */
public class FileRead {
    
    public static void main(String[] args) {
        char[] array = new char[100];
        try{
            FileReader input = new FileReader("myfile.txt");
            input.read(array);
            
            System.out.println("This is the data in the file: ");
            System.out.println(array);
        }catch(FileNotFoundException e){
            e.getStackTrace();
        }catch(IOException e){
            e.getStackTrace();
        }
        
    }
    
}
