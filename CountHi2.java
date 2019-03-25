
public class CountHi2 {
	
	public int countHi2(String str) {
		if(str.equals("") || str.length() < 2) return 0;
		
		if(str.charAt(str.length()-1) == 'i' && str.charAt(str.length()-2) == 'h' 
				&& ((str.length() > 2 && str.charAt(str.length()-3) != 'x') || str.length() == 2)) 
			
			return 1 + countHi2(str.substring(0, str.length()-1));
		
		  return countHi2(str.substring(0, str.length()-1));
	}

	public static void main(String[] args) {
		CountHi2 c = new CountHi2();
		
		System.out.println(c.countHi2("xhixhi"));
	}
}
