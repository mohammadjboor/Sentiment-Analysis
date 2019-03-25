
public class CountAbc {
	
	public int countAbc(String str) {
		if(str.equals("") || str.length() < 3) return 0;
		
		if(str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba"))
		  return 1 + countAbc(str.substring(1));
		
		return countAbc(str.substring(1));
	}

	public static void main(String[] args) {
		CountAbc c = new CountAbc();
		System.out.println(c.countAbc("abaxxabc"));

		
	}
}
