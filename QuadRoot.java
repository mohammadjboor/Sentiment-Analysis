public class QuadRoot {
//Binary Search
//convert to loop
	public int quad(int x, int start, int end) {
		int s = start;
		int e = end;
		int i = (s + e) / 2;

		int quad = i * i * i;
		if (quad == x) {
			return i;
		} else if (quad > x) {
			return quad(x, start, i - 1);
		} else {
			return quad(x, i + 1, end);
		}
	}

	public static void main(String[] args) {
		QuadRoot qr = new QuadRoot();
		int q = qr.quad(64, 0, 64);
		System.out.println(q);

	}
}
