class Queue {
	char[] data;
	Queue next;
}

class LinkedList {
	Queue head;
	Queue tail;
	int count;

	public LinkedList() {
		head = tail = null;
		count = 0;
	}

	public void push(char[] data) {
		Queue start = new Queue();
		start.data = data;
		start.next = head;
		head = start;
		count += 1;
		if (head.next == null) {
			tail = head;
		}

	}

	public void pop() {
		if (head != null) {
			Queue temp = head;
			if (head.next == null) {
				head = tail = null;
				count = 0;
			} else {
				while (temp.next.next != null) {
					temp = temp.next;
				}

				tail = temp;
				tail.next = null;
				count -= 1;
			}
		}

	}

	public void print() {
		Queue temp = head;
		while (temp != null) {
			for (int i = 0; i < temp.data.length; i++) {
				System.out.print(temp.data[i]);
			}
			System.out.println();
			temp = temp.next;
		}
	}
}

class Node {
	int key;
	LinkedList linked;
	Node left;
	Node right;
}

public class Solution {
	Node root;

	public Solution() {
		root = null;
	}

	public void addNode(Node node, int key, char[] data) {
		if (key < node.key) {
			if (node.left == null) {
				node.left = new Node();
				node.left.key = key;
				node.left.linked = new LinkedList();
				node.left.linked.push(data);
				return;
			}
			addNode(node.left, key, data);
		} else if (key > node.key) {
			if (node.right == null) {
				node.right = new Node();
				node.right.key = key;
				node.right.linked = new LinkedList();
				node.right.linked.push(data);
				return;
			}
			addNode(node.right, key, data);
		} else {
			node.linked.push(data);
		}

	}

	public void add(int key, char[] data) {
		if (root == null) {
			root = new Node();
			root.linked = new LinkedList();
			root.linked.push(data);
			root.key = key;
		} else {
			addNode(root, key, data);
		}
	}

	public void searchNode(Node node, int key) {
		if (key < node.key) {
			if (node.left == null) {
				System.out.println("Not found");
				return;
			}
			searchNode(node.left, key);

		} else if (key > node.key) {
			if (node.right == null) {
				System.out.println("Not found");
				return;
			}
			searchNode(node.right, key);
		} else {
			System.out.println(key);
			System.out.println(node.linked.count);
			node.linked.print();
		}

	}

	public void search(int key) {
		if (root != null) {
			searchNode(root, key);
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[] c = { 'a', 'b' };
		char[] c2 = { 'z', 'h' };
		char[] c3 = { 'm', 'o' };
		char[] c4 = { 'j', 'b' };
		char[] c5 = { 'e', 'd' };

		solution.add(10, c);
		solution.add(10, c2);
		solution.add(14, c3);
		solution.add(14, c4);
		solution.add(14, c5);
		solution.add(11, c3);
		solution.add(11, c4);
		solution.add(11, c5);

		solution.search(11);

	}
}
