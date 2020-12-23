/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOFile;

import java.util.Scanner;

/**
 *
 * @author chiangyong
 */
public class FileIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner fileName = new Scanner(System.in);
        
        CreateFile nFile = new CreateFile();
        WriteFile wFile = new WriteFile();
        ReadFile rFile = new ReadFile();
       
        System.out.println("Enter file name : ");
        String sFile = fileName.nextLine();
        
        System.out.println("\nCreate a new file:");
        nFile.NewFile(sFile);
        
        System.out.println("");
        wFile.writeFile(sFile);
         
        System.out.println("");
        rFile.readFile(sFile);
        
        
    }
    
}
