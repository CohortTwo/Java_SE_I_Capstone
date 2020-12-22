/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InnerClasses;

/**
 *
 * @author sridh
 */
public class InnerMethodClass {
   public void display(){
      int num = 23;
      class Inner{
         public void print() {
            System.out.println("This is method inner class "+num);
         }
      }
      Inner obj = new Inner();
      obj.print();
   }
   public static void main(String args[]){
      InnerMethodClass outer = new InnerMethodClass();
      outer.display();
   }
}
