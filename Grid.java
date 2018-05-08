public class Grid {

	public static void main(String[] args) {
		char[][] a = new char[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				a[i][j] = 'c';
			}
		}
		int c = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (a[i][j] == 'c')
					c++;
				if (a[i][j] == 'c' && i != 4 && j != 4) {

					a[i + 1][j] = '.';
					a[i][j + 1] = '.';
				}
			}
		}
		System.out.println(c);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}

	}

}
