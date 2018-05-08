import java.util.Scanner;

public class QuickSort {

	public int BinarySearch(int[] arr, int start, int end, int element) {

		int mid = (start + end) / 2;

		if (element == arr[mid]) {
			return mid;
			
		} else if (element > arr[mid]) {
			return BinarySearch(arr, mid + 1, end, element);
			
		} else if(element > arr[mid]){ 
			return BinarySearch(arr, start, mid - 1, element);
		}else{
			System.out.println("element not found");
			return -1;
		}
	}

	public int partition(int[] arr, int start, int end) {

		int pivot = start;
		int s = start + 1;
		int e = end;

		while (s <= e) {

			while (arr[pivot] > arr[s] && s <= e) {

				s++;
			}
			while (arr[pivot] < arr[e] && s <= e) {
				e--;
			}

			if (e > s) {
				swap(arr, s, e);
			}
		}

		swap(arr, pivot, e);
		return e;

	}

	public void swap(int[] arr, int start, int end) {

		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

	public void quickSort(int[] arr, int start, int end) {

		if (start >= end) {
			return;
		} else {
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		QuickSort qs = new QuickSort();

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		qs.quickSort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("========================");
		System.out.println(qs.BinarySearch(arr, 0, arr.length - 1, 8));
		
	}
}
