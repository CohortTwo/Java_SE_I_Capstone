/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InnerClasses;

/**
 *
 * @author sridhar
 */
class OuterClass {
  int x = 10;

  private class InnerClass {
    int y;
  }
  
  int displayInner()
  {
      InnerClass myInner = new InnerClass();
      return myInner.y;
  }
}

public class InnerPrivateClassExample {
  public static void main(String[] args) {
    OuterClass myOuter = new OuterClass();
    //OuterClass.InnerClass myInner = myOuter.new InnerClass();
    //InnerClass myInner = new InnerClass();
    System.out.println(myOuter.displayInner() + myOuter.x);
  }
}

