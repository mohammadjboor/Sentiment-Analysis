//Dynamic Programming with Fibonacci
public class DynamicPrograming {

	static long[] arr = new long[50000];

	public static long function(int x) {
		if (x == 0 || x == 1) {
			return 1;
		}
		
		if (arr[x] != -1) {
			return arr[x];
		} else {
			arr[x] = function(x - 1) + function(x - 2);
			return arr[x];
		}
	}

	public static void main(String[] args) {
		 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		System.out.println(function(85));
	}

}


