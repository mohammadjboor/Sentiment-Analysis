public class ListQueu {

	int[] a;
	int start;
	int end;
	int size;
	int c = 0;

	public ListQueu() {
		a = new int[5];
		start = 0;
		end = 0;
		size = a.length;
	}

	public void push(int x) {
		if (c != size) {
			a[end] = x;
			end += 1;
			c += 1;
			if (end == size) {
				end = 0;
			}
		}
	}

	public void pop() {
		if (c != 0) {
			start++;
			c--;

			if (start == size) {
				start = 0;
			}
		}

	}

	public void print() {
		int cc = c;
		int i = start;
		while (cc != 0) {
			System.out.println(a[i]);
			i++;
			if (i == size) {
				i = 0;
			}
			cc--;
		}

	}

	public static void main(String[] args) {
		ListQueu q = new ListQueu();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.push(5);
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.push(12);

		q.print();

	}

}
