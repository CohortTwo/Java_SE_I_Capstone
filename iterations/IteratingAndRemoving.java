/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections.iterations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author sridh
 */
public class IteratingAndRemoving {
    public static void main(String[] args) 
    { 
        List<Integer> al = new ArrayList<Integer>(); 
        al.add(10); 
        al.add(20); 
        al.add(30); 
        al.add(1); 
        al.add(2); 
  
        // Remove elements smaller than 10 using Iterator.remove() 
        Iterator itr = al.iterator(); 
        System.out.println("Original ArrayList : " + al);
        while (itr.hasNext()) 
        { 
            int x = (Integer)itr.next(); 
            if (x < 10) 
                itr.remove(); 
        } 
  
        System.out.println("Modified ArrayList : " + al); 
    }
}
