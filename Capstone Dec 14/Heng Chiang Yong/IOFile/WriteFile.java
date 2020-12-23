/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author chiangyong
 * Date: 23 December 2020
 */
public class WriteFile {
    
    String data;
    
    public void writeFile(String s){
        try{
            Scanner inp = new Scanner(System.in);
            FileWriter writefile = new FileWriter(s);
            System.out.println("Type your comments:");
            data = inp.nextLine();
            writefile.append(data);
            
            System.out.println("Data is written to file <"+s+">");
            writefile.close();
        }
        catch(IOException e){
            e.getStackTrace();
        }
        
    
    }
}
