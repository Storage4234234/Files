public class CalculatorStack
{
	private float [] nums = new float [4];
	private int top = -1;
	
	public void push(float x)
	{
		nums[++top] = x;
	}
	
	public float pop()
	{
		return nums[top--];
	}
	
	public int getTop()
	{
		return top;
	}
	
	public float [] getArray()
	{
		return nums;
	}
}
