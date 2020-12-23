/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OuterInner;

/**
 *
 * @author chiangyong
 */
public class OuterClass {
    
    int numeric;
    String str;
    
    class InnerClass{
        
        public int method(){
            return numeric;
        }
        
        public String methodString(){
            return str;
        }
    }
    
    public static void main(String args[]){
        
        OuterClass outer = new OuterClass();
        outer.numeric = 100;
        outer.str = "Outer Class String";
        
        OuterClass.InnerClass inner = outer.new InnerClass();
        
        System.out.println(inner.method());
        System.out.println(inner.methodString());
        
        
    }
    
}
