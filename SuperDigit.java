public class SuperDigit {

	public static int function(int x) {
		if (x < 10) {
			return x;
		}
		int sum = 0;
		while (x > 0) {
			sum += x % 10;
			x = x / 10;
		}
		return function(sum);
	}

	public static void main(String[] args) {
		System.out.println(function(239));

	}
}
