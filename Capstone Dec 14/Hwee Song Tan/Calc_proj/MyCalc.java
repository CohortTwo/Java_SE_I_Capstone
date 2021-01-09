/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Design.Calfunc;

/**
 *
 * @author andrew
 */
public class MyCalc implements Calfunc {

    @Override
    public int addFunc(int a, int b) {
        return(a+b);     
    }

    @Override
    public int subFunc(int a, int b) {
        return(a-b);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int multiply(int a, int b) {
        return(a*b);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int divide(int a, int b) {
        return(a/b);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        MyCalc m1 = new MyCalc();
        
        System.out.print(m1.addFunc(10,10)+"::"+m1.subFunc(30, 20)+"::"+m1.multiply(10, 10)+"::"+m1.divide(100, 10));
    }
    
}
