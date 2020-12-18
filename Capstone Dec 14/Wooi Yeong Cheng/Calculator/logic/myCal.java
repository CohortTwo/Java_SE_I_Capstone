
package logic;

import design.Calculator;

public class myCal implements Calculator {
    
   
    @Override
    public int add(int j, int k) {
        return (j + k);   
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int sub(int j, int k) {
        return (j - k);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int mul(int j, int k) {
        return (j * k);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int div(int j, int k) {
        return (j / k);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        
        
        myCal cl = new myCal();
        
        System.out.println("10 + 60 = " + cl.add(10, 60));
        System.out.println("456 - 123 = " + cl.sub(456, 123));
        System.out.println("12 x 12 = " + cl.mul(12, 12));
        System.out.println("120 / 12 = " + cl.div(120, 12));
        
        
    }
    
}
