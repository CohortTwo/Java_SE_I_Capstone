/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfxapp;

/**
 *
 * @author chiangyong
 */
public class NumOperator {
    
    //private int number;
    
    public String primeNumber(int num){
        
        boolean flag = false;
        
        if(num > 1)
        {
            for(int i = 2; i < num; i++)
                if(num%i == 0){
                    flag = true;
                    break;
                    //return num + " is not a prime number";
                }
        }
        else 
            flag = true;
        
        if(!flag)
            return num + " is a prime number";
        else 
            return num + " is not a prime number";
        
    }
    
    public String EvenOdd(int num){
        
        if(num%2 == 0)
            return num + " is an even number";
        else 
            return num + " is an odd number";
    }
    
    public int CubeTheNumber(int num){
        
        return num*num*num;
    }
    
    public int SquareTheNumber(int num){
        
        return num*num;
    }
}
