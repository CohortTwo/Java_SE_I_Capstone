/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banking;
import Design.B_guides;

public class Banks implements B_guides { 

    @Override
    public float theSavAcc(int age) {
        if (age >60 || age <20 ) return (float)2.50;
       else return (float)1.00;
        
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Banks b1 = new Banks();
           
        
        System.out.println("Saving rate above 60 :: "+b1.theSavAcc(61));
        System.out.println("Saving rate below 20 :: "+b1.theSavAcc(10));
        
        System.out.println("Current rate above 10K :: "+b1.theCurAcc(12000));
        System.out.println("Current rate below 10K :: "+b1.theCurAcc(5000));
        
        System.out.println(B_guides.interbank());
        
    }


    
}

//if (age >60 || age <20 ) return 2.50%;
//       else return 1.00%;

//if (amt >10000) return 1.5%;
//        else return 1%;