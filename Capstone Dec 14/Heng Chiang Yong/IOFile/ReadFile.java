/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 *
 * @author chiangyong
 */
public class ReadFile {
    
    public static void readFile(String s){
      // BufferedReader in  = new BufferedReader(s);
       CharBuffer content = CharBuffer.allocate(100);
       char[] array = new char[100];
       
        try{
            FileReader readfile = new FileReader(s);
            Boolean status = readfile.ready();
            if(status){
                readfile.read(array);
                readfile.read(content);
                System.out.println("The content read from the file <"+s+"> is ");
                //System.out.println(content);
                System.out.println(array);
                readfile.close();
            }
            else
            {
                System.err.println("File is not ready!");
            }
        }
        catch(IOException e){
            e.getStackTrace();
        }
        
    }
    
}
