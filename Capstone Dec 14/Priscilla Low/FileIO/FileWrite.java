/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIO;
import java.io.FileWriter;
/**
 *
 * @author blueg
 */
public class FileWrite {
    public static void main(String[] args) {
        String text = "sample paragraph to write into the file";
        int num = 300;
        
        try{
            FileWriter output = new FileWriter("myfile.txt");
//            FileWriter output = new FileWriter("myfile.txt",true); // use this line if you want to append text after each run
            output.write(" \n");
            output.write(text);
            System.out.println("Data has been written.");
            
            output.close();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
