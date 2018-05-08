
public class Bashar_linkedlist {

	static class Node
	{
		public int value;
		public Node next;
		public Node prev;
		
		public Node(int v)
		{
			value = v;
			next = null;
			prev = null;
		}
	}
	
	
	static Node first = null;
	static Node last  = null;
	public static void insert(int value)
	{
		if (first ==null)
		{
			first = new Node(value);
			last = first;
		}
		else
		{
			Node temp = new Node(value);
			last.next = temp;
			temp.prev = last;
			last = last.next;
		}
	}
	
	public static void print()
	{
		Node p = first;
		while (p!=null)
		{
			System.out.print(p.value+" --> ");
			p = p.next;
		}
		System.out.println("null");
	}
	
	public static void print_back()
	{
		Node p = last;
		while (p!=null)
		{
			System.out.print(p.value+" --> ");
			p = p.prev;
		}
		System.out.println("null");
	}
	
	public static void delete_value(int v)
	{
		Node f = first;
		Node l = last;
		int c=0;
		while (f!=null ||l!=null  )
		{
			
			if (f.value == v )
			{
				// First element
				if (f.prev == null)
				{
					first = first.next;
					first.prev = null;
					
				}
				// Last element
				else if (f.next==null)
				{
					last  = last.prev;
					last.next = null;
				}
				else
				{
					Node back = f.prev;
					Node next= f.next;
					
					back.next = next;
					next.prev = back;
				}
				
				break;
			}
			else if (l.value == v )
			{
				// Last element
				if (l.next==null)
				{
					last  = last.prev;
					last.next = null;
				}
				else
				{
					Node back = l.prev;
					Node next= l.next;
					
					back.next = next;
					next.prev = back;
				}
				
				break;
			}
			
			f = f.next;
			l = l.prev;
			c++;
		}
		
	}
	
	public static void insertAtEnd(int value)
	{
		insertAt(value, -1);
	}
	public static void insertAtBegain(int value)
	{
		insertAt(value, 0);
	}
	
	public static void insertAt(int value, int i)
	{
		Node f = first;
		
		int c=0;
		while (f!=null && i!=-1)
		{
			
			if (c == i )
			{
				// First element
				if (f.prev == null)
				{
					Node temp = new Node(value);
					temp.next = first;
					first.prev = temp;
					first = temp;
					
				}
				else
				{
					
					Node temp = new Node(value);
					Node back = f.prev;

					temp.next = f;
					temp.prev = back;
					
					back.next = temp;
					f.prev = temp;
					
				}
				
				return;
			}
			
			f =f.next;
			c++;
		}
		
		
			Node temp = new Node(value);			
			last.next = temp;
			temp.prev = last;
			
			last = temp;

	}
	
	public static Node getByValue(int value)
	{
		Node f = first;
		
		int c=0;
		while (f!=null)
		{
			
			if (f.value == value )
			{
				return f;
			}
			f=f.next;
		}
		return null;
	}
	
	public static Node getByIndex(int index)
	{
		Node f = first;
		
		int c=0;
		while (f!=null)
		{
			if (c == index)
			{
				return f;
			}
			
			c++;
			f=f.next;
		}
		return null;
	}
	
	public static void delete_index(int v)
	{
		Node f = first;

		int c=0;
		while (f!=null  )
		{
			
			if (c == v )
			{
				// First element
				if (f.prev == null)
				{
					first = first.next;
					first.prev = null;
					
				}
				// Last element
				else if (f.next==null)
				{
					last  = last.prev;
					last.next = null;
				}
				else
				{
					Node back = f.prev;
					Node next= f.next;
					
					back.next = next;
					next.prev = back;
				}
				
				break;
			}
			
			
			f = f.next;
			c++;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		insert(1);
		insert(2);
		insert(3);
		insert(4);
		
		print();print_back();
		//print_back();
		
		System.out.println("\ndelete_value(4)");
		delete_value(4);
		
		print();print_back();
		//print_back();
		
		System.out.println("\ninsertAt(100, 100)");
		insertAt(100, 100);
		
		print();print_back();
		//print_back();
		
		System.out.println("\ninsertAtBegain(99)");
		insertAtBegain(99);
		print();print_back();
		//print_back();
		
		System.out.println("\ninsertAtEnd(200)");
		insertAtEnd(200);
		print();print_back();
		//print_back();
		
		System.out.println("\n"+getByIndex(3).value+" is at index 3");
		System.out.println(getByValue(99).value+" is equal to 99");
		
		System.out.println("\ndelete_index(0)");
		delete_index(0);
		print();print_back();

		System.out.println("\ndelete_value(100)");
		delete_value(100);
		print();print_back();
		
		System.out.println("\ndelete_value(200)");
		delete_value(200);
		print();print_back();
		
		
	}

}
