public class StackTest
{	
	public static void main (String [] args)
	{
		StackNode first = new StackNode(5);
		first.push(6);
		first.insert(7, first);
		first.insert(0, first);
		first.insert(12000, first);
		first.insert(-5, first);
		
		System.out.println(first.print(first));
	}
}
