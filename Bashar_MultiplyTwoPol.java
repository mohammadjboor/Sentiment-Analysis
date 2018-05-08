import java.util.Scanner;


public class Bashar_MultiplyTwoPol {

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
	
	static class LinkedList
	{
		Node first = null;
		Node last  = null;
		
		public void insert(int value)
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
		
		public void print()
		{
			Node p = first;
			while (p!=null)
			{
				System.out.print(p.value+" ");
				p = p.next;
			}
			System.out.println();
		}
		
		public void print_back()
		{
			Node p = last;
			while (p!=null)
			{
				System.out.print(p.value+" --> ");
				p = p.prev;
			}
			System.out.println("null");
		}
		
		public void delete_value(int v)
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
		
		public void insertAtEnd(int value)
		{
			insertAt(value, -1);
		}
		public void insertAtBegain(int value)
		{
			insertAt(value, 0);
		}
		
		public void insertAt(int value, int i)
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
						f.value = f.value + value;
//						
//						Node temp = new Node(f.value+ value);
//						Node back = f.prev;
//	
//						temp.next = f;
//						temp.prev = back;
//						
//						back.next = temp;
//						f.prev = temp;
//						
					}
					
					return;
				}
				
				f =f.next;
				c++;
			}
			
			if(c==0)
			{
				insert(value);
			}
			else
			{
				Node temp = new Node(value);			
				last.next = temp;
				temp.prev = last;
				
				last = temp;
			}
		}
		
		public Node getByValue(int value)
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
		
		public Node getByIndex(int index)
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
		
		public void delete_index(int v)
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
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int C=0, l1=0, l2=0;
		Scanner sc = new Scanner(System.in);
		C=sc.nextInt();
		
		for (int i=0; i<C; i++)
		{
			l1=sc.nextInt();
			l2=sc.nextInt();
			LinkedList first = new LinkedList();
			LinkedList second= new LinkedList();
			
			for (int x=0; x<l1; x++)
			{
				int temp;
				temp=sc.nextInt();
				first.insert(temp);
			}
			
			for (int x=0; x<l2; x++)
			{
				int temp;
				temp=sc.nextInt();
				second.insert(temp);
			}
			
			LinkedList final_ans = new LinkedList();
			
			for (int x=0; x<l2; x++)
			{
				int val2 = second.getByIndex(x).value;
				for (int y=0; y<l1; y++)
				{
					int val1 = first.getByIndex(y).value;
					
					int res = val1*val2;
					final_ans.insertAt(res, x+y);
		
				}
			}
			
			final_ans.print();
			
		}
		
	}

}
