package workshop_jshell;
//Using example of 10

public class Fibonacci{
	public static int recurMethod(int n){
	if(n == 0){
		return 0;
	}
	if(n == 1 || n == 2){
			return 1;
		}
	return recurMethod(n-2) + recurMethod(n-1);
	}
    public static void main(String args[]) {
	int example = 10;
	System.out.print("Fibonacci "+ example +" numbers: ");
	for(int i = 0; i < example; i++){
			System.out.print(recurMethod(i) +" ");
		}
	}
}