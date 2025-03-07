public class StackNode
{		
	private int data;
	private StackNode next;
	
	public StackNode(int d, StackNode n) 
	{
		data = d;
		next = n;
	}
	
	public StackNode(int d) 
	{
		data = d;
	}
	
	public void setData(int d)
	{
		data = d;
	}
		
	public int getData() 
	{
		return data;
	}
		
	public void setNext(StackNode n)
	{
		next = n;
	}
	
	public StackNode getNext() 
	{
		return next;
	}
		
	public void push(int d)
	{
		next = new StackNode(d);
	}
		
	public void pop()
	{
		next = null;
	}
	
	public void insert(int data, StackNode head)
	{
		StackNode temp = new StackNode(data);
		StackNode previous;
		StackNode current;
		previous = current = head;
		
		while (current != null && temp.getData() > current.getData())
		{
			previous = current;
			current = current.getNext();
		}
		
		if (previous != current)
		{
			previous.setNext(temp);
			temp.setNext(current);
		}
		else
		{
			temp.setData(head.getData());
			temp.setNext(head.getNext());
			head.setData(data);
			head.setNext(temp);
		}
	}
	
	public String print(StackNode head)
	{
		StackNode current = head;
		String list = "";
		
		while (current != null)
		{
			list = list + String.valueOf(current.getData() + " ");
			current = current.getNext();
		}
		
		return list;
	}
}