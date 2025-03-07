public class ArrayStack
{
	public static float [] nums = new float [4];
	public static int top = -1;
	
	public static void push(float x)
	{
		nums[++top] = x;
	}
	
	public static float pop()
	{
		return nums[top--];
	}
	
	public static void printArray()
	{
		for (int i = 0; i < top + 1; i++)
		{
			System.out.print(nums[i] + " ");
		}
		System.out.println("");
	}
	
	public static void main (String [] args)
	{
		try
		{
			ArrayStack.push(1);
			ArrayStack.printArray();
			ArrayStack.push(23);
			ArrayStack.printArray();
			ArrayStack.push(323);
			ArrayStack.printArray();
			ArrayStack.push(2.3f);
			ArrayStack.printArray();
			ArrayStack.pop();
			ArrayStack.printArray();
			ArrayStack.push(2);
			ArrayStack.printArray();
			ArrayStack.push(10);
		}
		catch (Exception e)
		{
			System.out.println("Index out of bounds.");
		}
	}
}
