public class Solution {

	// static int result = 1;
	public static int function(int x) {
		if (x == 1) {
			return 1;
		}

		return x * function(x - 1);
	}

	// way number 2
	/*
	 * public static void function(int x){ if(x == 1){ return; } result = x *
	 * result; function(x-1);
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// way number 2
		// function(6);
		// System.out.println(result);
		System.out.println(function(6));
	}
}
