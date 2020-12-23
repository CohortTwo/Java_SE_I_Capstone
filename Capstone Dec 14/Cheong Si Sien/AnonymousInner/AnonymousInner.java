package innerclass_anon;

// anonymous class method
abstract class Mark 
{ 
	int SubjMark = 80; 
	abstract void getMark(); 
} 

class AnonymousInner
{ 
	public static void main(String[] args) 
	{ 
		Mark obj=new Mark() 
                {
                @Override              // this is the anonymous class replacing MyMark Class
                public void getMark(){
                System.out.print("Mark is " + SubjMark);}     
                } ;
		
                obj.getMark();	 
	} 
} 

// For Anonymoous, no need for the following extends codes
//public class MyMark extends Mark ==> reduce coding