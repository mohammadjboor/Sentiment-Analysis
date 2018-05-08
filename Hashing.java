import java.util.Scanner;

class HashNode {
	char arr[] = new char[6];
	int data;
	HashNode next;
}

class LinkedList {

	HashNode head;
	HashNode tail;

	public LinkedList() {
		head = tail = null;
	}

	public void push(char[] arr, int data) {
		if (head == null) {
			head = tail = new HashNode();
			head.arr = arr;
			head.data = data;
			tail.next = null;
		} else {
			tail = new HashNode();
			tail = tail.next;
			tail.arr = arr;
			tail.data = data;
			tail.next = null;
		}
	}
	
	public int search(char[] a){
		HashNode temp = head;
		while(temp.next != null){
			if(temp.arr == a){
				return temp.data;
			}else{
				temp = temp.next;
			}
		}
		
		
		// i need to create function compare to compare arrays
		if(temp.arr == a){
			return temp.data;
		}else{
			return -11111;
		}
		
	}
}

public class Hashing {

	public int power(int base, int pow) {
		if (pow == 0) {
			return 1;
		}
		int num = 1;
		for (int i = 1; i <= pow; i++) {
			num = num * base;
		}
		return num;
	}

	public int Hash(char[] arr, int size) {
		int x = 0;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			x = arr[i] - 64;
			index += x * power(26, i);
		}
		return index % size;
	}

	public int check(char[] a) {
		int index = Hash(a, arr.length);
		int data=-1;
		if (arr[index] == null) {
			System.out.println("Data Not Found");
		} else {
			 data = arr[index].search(a);
		}
		return data;
	}

	public void insert(char[] a, int data) {
		int index = Hash(a, arr.length);
		if (arr[index] == null) {
			arr[index] = new LinkedList();	
		} 
		arr[index].push(a, data);
	}

	static LinkedList arr[] = new LinkedList[100];
	public static void main(String[] args) {
		
		Hashing hash = new Hashing();
		Scanner sc = new Scanner(System.in);
		
		for (int T = 0; T < 5; T++) {
			String strArray = sc.next();
			int data = sc.nextInt();

			char[] a = new char[strArray.length()];
			for (int i = 0; i < strArray.length(); i++) {
				a[i] = strArray.charAt(i);
			}

			hash.insert(a, data);
			

		}
		char[] b = {'A'};
		System.out.println(hash.check(b));

	}

}
