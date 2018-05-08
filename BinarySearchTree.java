class Node1 {

	public int key;
	Node1 right;
	Node1 left;
}

class Queu {
	Queu next;
	Node1 queuNode;
}

class LinkedQueu {
	Queu head;
	Queu tail;

	public LinkedQueu() {
		head = tail = null;
	}

	public void pushQ(Node1 node) {
		Queu start = new Queu();
		start.next = head;
		start.queuNode = node;
		head = start;

		if (head.next == null) {
			tail = head;
		}
	}

	public Node1 pop() {
		Node1 tailTemp = null;
		if (head != null) {
			Queu temp = head;
			tailTemp = tail.queuNode;
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

		return tailTemp;
	}
}

public class BinarySearchTree {
	Node1 root;

	public BinarySearchTree() {
		root = null;
	}

	private void addNode(Node1 node, int x) {

		if (x < node.key) {
			if (node.left == null) {
				node.left = new Node1();
				node.left.key = x;
				return;
			}
			addNode(node.left, x);
		} else {
			if (node.right == null) {
				node.right = new Node1();
				node.right.key = x;
				return;
			}
			addNode(node.right, x);
		}
	}

	public void add(int x) {
		if (root == null) {
			root = new Node1();
			root.key = x;
		} else {
			addNode(root, x);
		}
	}

	public int findMin(Node1 node) {
		Node1 temp = node;
		while (temp.left != null) {
			temp = temp.left;
		}

		return temp.key;
	}

	private Node1 deleteNode(Node1 node, int key) {
		if (node == null) {
			return node;
		} else if (key > node.key) {
			node.right = deleteNode(node.right, key);
		} else if (key < node.key) {
			node.left = deleteNode(node.left, key);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				int tempkey = findMin(node.right);
				node.key = tempkey;
				node.right = deleteNode(node.right, tempkey);
			}
		}

		return node;
	}

	public void delete(int x) {
		root = deleteNode(root, x);
	}

	// dfs pre order
	private void printTree(Node1 node) {
		if (node == null) {
			return;
		}
		System.out.println(node.key);
		printTree(node.left);
		printTree(node.right);
	}

	public void print() {
		printTree(root);
	}

	// dfs in order
	private void printLeftTree(Node1 node) {
		if (node == null) {
			return;
		}
		printLeftTree(node.left);
		System.out.println(node.key);
		printLeftTree(node.right);
	}

	public void printLeft() {
		printLeftTree(root);
	}

	// dfs post order
	private void printRightTree(Node1 node) {
		if (node == null) {
			return;
		}
		printRightTree(node.left);
		printRightTree(node.right);
		System.out.println(node.key);
	}

	public void printRight() {
		printRightTree(root);
	}

	public void BFS(Node1 node) {
		Node1 temp = node;

		LinkedQueu lq = new LinkedQueu();

		while (temp != null) {
			System.out.println(temp.key);
			if (temp.left != null) {
				lq.pushQ(temp.left);
			}
			if (temp.right != null) {
				lq.pushQ(temp.right);
			}

			temp = lq.pop();

		}

	}

	public void printBFS() {
		BFS(root);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.add(12);
		bst.add(9);
		bst.add(8);
		bst.add(7);
		bst.add(15);
		// bst.delete(2);
		/*
		 * System.out.println("******* dfs pre order ********"); bst.print();
		 * System.out.println("******* dfs in order ********"); bst.printLeft();
		 * System.out.println("******* dfs post order ********");
		 * bst.printRight();
		 */
		// System.out.println(bst.root.key);

		bst.printBFS();

	}

}
