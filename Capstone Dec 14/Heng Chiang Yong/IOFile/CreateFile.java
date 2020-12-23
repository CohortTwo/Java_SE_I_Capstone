/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOFile;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author chiangyong
 */
public class CreateFile {
    public static void NewFile(String s){
        try{
        File newfile = new File(s);
        Boolean status = newfile.createNewFile();
        if(status)
            System.out.println("New file <"+s+"> is created");
        else
            System.err.println("This file <"+s+"> is exist!");
        }
        catch(IOException e){
            e.getStackTrace();
        }
    }
}
