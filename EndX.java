
public class EndX {

	public String endX(String str) {
		  if (str.equals("") || str.length() == 1) return str;
		
		  if (str.charAt(0) == 'x') 
		    return  endX(str.substring(1)) + "" + str.charAt(0);
		  else
			  return  str.charAt(0) +""+endX(str.substring(1)) ;

		  
}
	
	public static void main(String[] args) {
		EndX e = new EndX();
		System.out.println(e.endX("xhixhix"));
	}
}
