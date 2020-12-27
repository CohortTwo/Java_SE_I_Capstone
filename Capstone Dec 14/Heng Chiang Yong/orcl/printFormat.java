/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcl;

/**
 *
 * @author chiangyong
 */
public class printFormat {
    
    public void printDeptRec(String s, int column){
        
        String print[] = new String[column];
        int a = 0;
        int st = 0;
      //  String tmpStr;
              
        for(int i = 0; i < s.length(); i++){
           
            if(s.charAt(i) == ' '){
               // System.out.println("white space :" + i);
                if(a == 0)
                {
                   print[a] = s.substring(st, i); 
                }
                else
                {
                   print[a] = s.substring(st+1, i); 
                }
                a++;
                st = i;
                if(a==(column-1))
                    print[a] = s.substring(st+1, s.length()); 
            }
        }
        
        for(int i = 0; i < print.length; i++)
        {
            if(i==0)
            {
                System.out.print(print[i]);
                for(int z = 0; z < 9 - print[i].length(); z++)
                    System.out.print(" ");
                
            }
            else if (i==1)
            {
                System.out.print(print[i]);
                for(int z = 0; z < 30 - print[i].length(); z++)
                    System.out.print(" ");
            }
            else if ( i==2)
            {
                 System.out.print(print[i]);
                for(int z = 0; z < 12 - print[i].length(); z++)
                    System.out.print(" ");
            }
            else
                System.out.print(print[i]);
            
        }
         System.out.println("");
    }
    
    public void printEmpRec(String str, int col)
    {
        String arrayPrint[] = new String[col];
        int arrIndex = 0;                               //array index
        int strcnt = 0;                                 //string count
        int spaceLength = 0;
        
        for(int i = 0; i < str.length(); i++){
           
            if(str.charAt(i) == ' '){
               // System.out.println("white space :" + i);
                if(arrIndex == 0)
                {
                   arrayPrint[arrIndex] = str.substring(strcnt, i); 
                }
                else
                {
                   arrayPrint[arrIndex] = str.substring(strcnt+1, i); 
                }
                arrIndex++;
                strcnt = i;
                if(arrIndex==(col-1))
                    arrayPrint[arrIndex] = str.substring(strcnt+1, str.length()); 
            }
        }
        
        for(int i = 0; i < arrayPrint.length; i++)
        {
            
            System.out.print(arrayPrint[i]);
            switch(i)
            {
                case 0:
                    spaceLength = 9 - arrayPrint[i].length();
                    break;
                case 1:
                    spaceLength = 20 - arrayPrint[i].length();
                    break;
                case 2:
                    spaceLength = 25 - arrayPrint[i].length();
                    break;
                case 3:
                    spaceLength = 25 - arrayPrint[i].length();
                    break;
                case 4:
                    spaceLength = 20 - arrayPrint[i].length();
                    break;
                case 5:
                    spaceLength = 12 - arrayPrint[i].length();
                    break;
                case 6:
                    spaceLength = 12 - arrayPrint[i].length();
                    break;
                case 7:
                    spaceLength = 14 - arrayPrint[i].length();
                    break;
                case 8:
                    spaceLength = 6 - arrayPrint[i].length();
                    break;
                case 9:
                    spaceLength = 10 - arrayPrint[i].length();
                    break;
                case 10:
                    spaceLength = 8 - arrayPrint[i].length();
                    break;
                default:
                    spaceLength = 3;
                    break;
                    
            }
            
            if(spaceLength >= 0)
            {
                for(int z = 0; z < spaceLength; z++)
                   System.out.print(" ");
            }
            
        }
         System.out.println("");
        
        
    }
    public static void main(String args[])
    {
        printFormat report = new printFormat();
        report.printDeptRec("Dept_ID Dept_Name ManagerID LocationID", 4);
        report.printDeptRec("This is a kite", 4);
        report.printDeptRec("How troubleshome is eveything", 4);
        
    }
}
