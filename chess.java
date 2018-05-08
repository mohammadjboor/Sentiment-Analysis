import java.util.Scanner;


public class chess {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int c =0;
		if(s.equals("a1") || s.equals("a8") || s.equals("i1") || s.equals("i8")){
			c=3;
		}
		System.out.println(c);

	}

}
