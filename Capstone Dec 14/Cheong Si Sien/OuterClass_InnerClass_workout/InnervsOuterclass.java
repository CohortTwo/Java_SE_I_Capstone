package innerclass_example;

// This program makes use of SCIENCE which consists of 3 subjects
// Physics, Biology and Chemistry. Using OuterClass to represent Science
// and innerClass to represent Physics to teach myself concept of INNER and 
// OUTER class.


class OuterClass 
{
   int sci = 80;   // science mark is the OuterClass variable
   static int Agrade = 75;
   public int getPhy(){ 
   InnerClass inn = new InnerClass();
   return inn.phy;}
           
   class InnerClass {    //inner class
      OuterClass out;
   
      int phy = 50;  // Physics mark is the InnerClass variable
      
      public void print() {      // method print() in inner class
         System.out.println("\033[0;31m This is an inner class (Physics) print method");
      }     

  
      public int getSci(){    // Inner class can access Outer class using this public get method
          return sci;
      }
   
   } 

   void display_Inner() {        // Outer class accessing the inner class method print()
      InnerClass inner = new InnerClass();
      inner.print();
   }
}
   
public class InnervsOuterclass {
   public static void main(String args[]) {
      // Instantiating the outer class 
      OuterClass MyOuter = new OuterClass();
      
      // Instantiating the inner class 
      OuterClass.InnerClass MyInner = MyOuter.new InnerClass();
      
      // Accessing the display_Inner() method.
      System.out.println("\033[0;30m Now in MAIN");
      System.out.println("\033[0;34m Outer Class has variable Sci = 80 marks");
      System.out.println("\033[0;34m MyOuter is new OuterClass object: OuterClass MyOuter = new OuterClass()");
      System.out.println();
      System.out.println("\033[0;31m Inner Class has print() method and variable Phy = 50 marks");
      System.out.println("\033[0;31m MyInner is a new InnerClass object: OuterClass.InnerClass MyInner = MyOuter.new InnerClass();");
      System.out.println();
      System.out.println("\033[0;30m InnerClass object access InnerVariable \033[0;31m MyInner.phy ==> " + MyInner.phy);
      System.out.print("\033[0;30m InnerClass object access InnerMethod \033[0;31m MyInner.print ==> ");
      MyInner.print();
      System.out.println("\033[0;30m InnerClass object access OuterVariable \033[0;31m MyInner.getSci() ==> " + MyInner.getSci());
      System.out.println();
      System.out.print("\033[0;30m OuterClass object access InnerMethod \033[0;34m MyOuter.display_Inner ==> ");
      MyOuter.display_Inner();
      System.out.println("\033[0;30m OuterClass object access OuterVariable \033[0;34m MyOuter.sci ==> " + MyOuter.sci);
      System.out.println("\033[0;30m OuterClass object access InnerVariable \033[0;34m MyOuter.getPhy() ==> " + MyOuter.getPhy());
      System.out.println();
      System.out.println("\033[0;30m Access STATIC OuterClass Variable Agrade \033[0;35m OuterClass.Agrade, Note: no need create new object ==> " + OuterClass.Agrade);
   }
}