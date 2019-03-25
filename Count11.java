
public class Count11 {

	public int count11(String str) {
		if(str.equals("") || str.length() < 2) return 0;
		
		if(str.substring(0, 2).equals("11"))
			return 1 + count11(str.substring(2));
		  
		return count11(str.substring(1));
	}
	
	public static void main(String[] args) {
		Count11 c = new Count11();
		System.out.println(c.count11("11abc1"));

	}

}
