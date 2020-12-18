package calculatorinterface;
      
  interface functions {
        double add(double a, double b);
        double add(double a, double b, double c);
        double minus(double a, double b);
        double multiply (double a, double b);
        double division (double a, double b);
    }
     
    class Calculator implements functions {

       
        public double test(double a, double b, double c){
        return (a * b * c);}
        
        @Override
        public double add(double a, double b, double c){
        return (a + b + c);}
        
        @Override
        public double add(double a, double b){
        return (a + b + a + b);}
        
        @Override
        public double minus(double a, double b){
        return (a - b);}
    
         @Override
        public double multiply(double a, double b){
        return (a * b);}
        
         @Override
        public double division(double a, double b){
        return (a / b);}

        }

        class Action {
           public static void main (String[] args) {
               Calculator newObj = new Calculator();
               System.out.println("addition of 2.5 and 2.0 and 1.0 = " + newObj.add(2.5, 2.0, 1.0));
               System.out.println("addition of 2.5 and 2.0 and 1.0 = " + newObj.add(2.5, 2.0));
               System.out.println("substraction of 2.5 and 2.0 = " + newObj.minus(2.5, 2.0));
               System.out.println("multiplication of 2.5 and 2.0 = " + newObj.multiply(2.5, 2.0));
               System.out.println("division of 2.5 and 2.0 = " + newObj.division(2.5, 2.0));
                System.out.println("test of 2.5 and 2.0 = " + newObj.test(4.0, 2.0, 3.0));
                          }

    }
