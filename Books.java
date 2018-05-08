import java.util.Scanner;

//Binary Search with cum sum
public class Books {
	static int[] cumarr;
	static int index=0;
	static int Best =-1;
	static int orginstart=-1;
	
	public void cum(int[] arr) {
		cumarr = new int[arr.length + 1];

		for (int i = 0; i < cumarr.length; i++) {
			if (i == 0) {
				cumarr[i] = 0;
			} else {
				cumarr[i] = arr[i - 1] + cumarr[i - 1];
			}
		}

		for (int i = 0; i < cumarr.length; i++) {
			System.out.println(cumarr[i]);
		}
	}
	
	
	public int binarySearch(int start, int end , int time){
		int l = start;
		int r = end;
		int mid = (l+r) / 2;
		if(l>r){
			return index;
		}
		if(cumarr[mid] - cumarr[orginstart-1] > time){
			binarySearch(l, mid-1, time);
		}else{
			index = mid;
			binarySearch(mid+1, r, time);
		}
		
		return index;
	}

	public static void main(String[] args) {
		Books b = new Books();
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int T = in.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		b.cum(arr);		
		int s = 1;
		orginstart = 1;
		index = b.binarySearch(1, cumarr.length-1, T);
		Best = index - s +1;
		
		for(int i=2; i <= cumarr.length-1; i++){
			orginstart=i;
			index = b.binarySearch(i, cumarr.length-1, T);
			if(index - i+1 > Best){
				Best = index - i + 1;
			}
		}
		
		System.out.println("+++++++++++");
		System.out.println(Best);
	}
}
