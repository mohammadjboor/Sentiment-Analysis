public class Even {
	static int count = 0;

	public static void func(int x) {
		if (x == 1) {
			return;
		} else {
			if (x % 2 == 0) {
				count += 1;
			}
		}
		func(x - 1);
	}

	public static void main(String[] args) {
		func(2);
		System.out.println(count);

	}
}
