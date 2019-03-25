
public class BunnyEars {

	public int bunnyEars(int bunnies) {
		  if(bunnies == 0)
		  return 0;
		  return 2 + bunnyEars(bunnies - 1);
		  
		  
		}
	
	public static void main(String[] args) {

		BunnyEars b = new BunnyEars();
		System.out.println(b.bunnyEars(3));
	}

}
