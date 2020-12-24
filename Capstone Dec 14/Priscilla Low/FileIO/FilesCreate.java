/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIO;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author blueg
 */
public class FilesCreate {
    public static void main(String[] args) {
        File file = new File("myfile.txt");
        
        try{
            if(file.createNewFile()){
                System.out.println("New file is created"); //the file gets created in HelloWorld package.
            }else{
                System.out.println("File already exists");
            }
        }catch(IOException e){
            e.getStackTrace();
        }
    }
}
