public class Fibonacci {
	
	public static int function(int x){
		if(x == 0 || x == 1){
			return 1;
		}
		
		return function(x-1) + function(x-2);
	}
	public static void main(String[] args) {
	System.out.println(function(5));

	}

}
