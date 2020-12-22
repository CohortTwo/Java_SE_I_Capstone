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
class OuterClass {
  int x = 10;

  // Non-static nested classes (inner classes) have access 
  //to other members of the enclosing class
  
  class InnerClass {
    int y = 5;
    int z = x*y;
    
  }
}

public class InnerClassExample {
  public static void main(String[] args) {
    OuterClass myOuter = new OuterClass();
    OuterClass.InnerClass myInner = myOuter.new InnerClass();
    System.out.println(myInner.y + myOuter.x + " " + myInner.z);
  }
}
