/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratorFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author chiangyong
 */
public class InteratorRemove {
    
    public static void main(String args[])
    {
        List<String> empList = new ArrayList<String>();
                
               empList.addAll(Arrays.asList(
                "Tom Becker",
                "Lucky Mar",
                "Rose Happy",
                "Starky Mick", 
                "Sky Rock", 
                "Nancy Dolly",
                "Suzie Drew",
                "Emily Hunter",
                "Larry Phillip",
                "Michelle Cristian"));
               
          Iterator itrList = empList.iterator();
          
          System.out.println("Original Employee List: "+ empList
                  +", array size: "+empList.size());
          
          while(itrList.hasNext())
          {

              String nameL = (String)itrList.next();
              //System.out.println(itrList.next());
              if(nameL == "Sky Rock")
                 itrList.remove();
          }
          
          System.out.println("Updated List: "+empList
                  +", update size: "+empList.size());
          }
    }
    
    
    
}
