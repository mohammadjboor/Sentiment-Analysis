public class ListStack {
	int[] a;
	int end;
	int size;

	public ListStack() {
		a = new int[10];
		end = -1;
		size = a.length;
	}

	public void push(int x) {
		if (end != size - 1) {
			a[end + 1] = x;
			end += 1;
		}
	}

	public void pop() {
		if (end != -1) {
			end--;
		}
	}

	public void print() {
		for (int i = 0; i <= end; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {

		ListStack s = new ListStack();
		s.push(1);
		s.push(2);
		s.pop();
		//s.pop();
		s.push(4);
		//s.pop();
		//s.pop();

		s.print();

	}

}
