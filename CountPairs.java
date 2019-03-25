
public class CountPairs {
	
	public int countPairs(String str) {

		if (str.equals("") || str.length() == 2) return 0;
		
		if(str.charAt(0) == str.charAt(2)) 
			return 1 + countPairs(str.substring(1));

		return countPairs(str.substring(1));
			
		
			  
	}
	public static void main(String[] args) {
		CountPairs c = new CountPairs();
		System.out.println(c.countPairs("ihihhh"));
	}
}
