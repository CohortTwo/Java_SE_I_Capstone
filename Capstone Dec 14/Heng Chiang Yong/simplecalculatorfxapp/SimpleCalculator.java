/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculatorfxapp;

import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import simplecalculatorfxapp.FXMLSimpleCalculatorController;
/**
 *
 * @author chiangyong
 */
public class SimpleCalculator {
    
    String TextStr;
    String errMsg = "";
       
    static String getFormattedText(double temp) {
        String resText = "" + temp;
        if (resText.lastIndexOf(".0") > 0) {
            resText = resText.substring(0, resText.length() - 2);
        }
        return resText;
    }
    
    public boolean isInStr(String str, char ch){
        for( int i = 0; i < str.length(); i++){
           if(str.charAt(i)==ch)
               return true;
        }
        return false; 
    }
    
     public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == 'x' || op1 == '/' || op1 == '^') && 
            (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
     
     // A utility method to apply an 
    // operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public float applyOp(char op,float b, float a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case 'x':
            return a * b;
        case '/':
            try{
            return a / b;
            }
            catch(ArithmeticException e){
               errMsg = "Divide by zero error!";
            }
        }
        return 0;
    }
    
    public double evaluateExp(String exp)
    {
        
        char[] tokens = exp.toCharArray();
        System.out.println("Tokens length =" + tokens.length);
        
        Stack<Float> num = new Stack<>();
        
        Stack<Character> opr = new Stack<>();
      //  StringBuffer strbuf = new StringBuffer();
        for( int i = 0; i < tokens.length; i++)
        {
           // System.out.println("Outside while Tokens["+i+"]"+" = " + tokens[i]);
            if(tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer strbuf = new StringBuffer();
               // System.out.println("inside for-if loop Tokens["+i+"]"+" = " + tokens[i]);
                while(i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                {
                        strbuf.append(tokens[i++]);
                        System.out.println("strbuf =" + strbuf);
                       if(i<tokens.length && tokens[i]=='.')
                            strbuf.append(tokens[i++]);
                }
                
                num.push(Float.parseFloat(strbuf.toString()));
               
                i--;
                System.out.println("i = " + i);
            }
            else if(tokens[i] =='(')
                opr.push(tokens[i]);
            
            else if(tokens[i] == ')')
            {
                while(opr.peek() != '(')
                    num.push(applyOp(opr.pop(),num.pop(),num.pop()));
                opr.pop();
            }
            
            else if(tokens[i] == '+' || tokens[i] == '-' 
                    || tokens[i] == 'x' || tokens[i]=='/' || tokens[i] == '^')
            {
               while (!opr.empty() && hasPrecedence(tokens[i],opr.peek()))
                  num.push(applyOp(opr.pop(), num.pop(), num.pop()));
 
                // Push current token to 'ops'.
                opr.push(tokens[i]);
            }
             
        }
        while(!opr.empty())
                    num.push(applyOp(opr.pop(),num.pop(),num.pop()));
                
                return num.pop();
    }
    
 
    
}
