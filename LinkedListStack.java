class Node {

	public int key;
	Node next;
}

public class LinkedListStack {
	Node head;
	Node tail;

	public LinkedListStack() {
		head = tail = null;
	}

	// for Stack
	public void push(int x) {
		if (head == null) {
			tail = head = new Node();
			tail.key = x;
			tail.next = null;
		} else {
			tail.next = new Node();
			tail = tail.next;
			tail.key = x;
			tail.next = null;
		}
	}

	// for Queu
	public void pushQ(int x) {
		Node start = new Node();
		start.next = head;
		start.key = x;
		head = start;

		if (head.next == null) {
			tail = head;
		}
	}

	// for stack & Queu
	public void pop() {
		if (head != null) {
			Node temp = head;
			if (temp.next == null) {
				head = tail = null;
			} else {
				while (temp.next.next != null) {
					temp = temp.next;
				}
				tail = temp;
				tail.next = null;
			}
		}
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.key);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		LinkedListStack lst = new LinkedListStack();
		lst.pushQ(2);
		lst.pushQ(4);
		lst.pushQ(6);

		// lst.push(4);
		// lst.push(10);
		// lst.push(20);
		// lst.print();

		lst.pop();
		lst.print();

	}

}
