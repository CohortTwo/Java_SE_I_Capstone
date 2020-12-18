package workshop_jshell;

public class palindrome {

    public static void main(String[] args) {

StringBuffer temp = new StringBuffer();
temp.setLength(0);
String s1 = "simon";
for (int i = s1.length(); i>0; i--){
System.out.println(s1.charAt(i-1));
    temp.append(s1.charAt(i-1));}
System.out.println(s1.equals("nomis"));
System.out.println();


temp.setLength(0);
s1 = "hahah";
for (int i = s1.length(); i>0; i--){
System.out.println(s1.charAt(i-1));
    temp.append(s1.charAt(i-1));}
System.out.println(s1.equals(temp.toString()));
        
    }
    
}
