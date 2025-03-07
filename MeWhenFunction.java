public class MeWhenFunction
{
	public static void main(String [] args)
	{
		int [] nums = new int [10];
		
		for (int i = 0; i < nums.length; i++)
		{
			nums[i] = (int) (Math.random() * 301) + 200;
		}
		
		for (int i = 0; i < nums.length; ++i)
		{
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < nums.length - 1; ++i)
		{
			swapValues(nums, i);
		}
		
		for (int i = 0; i < nums.length; ++i)
		{
			System.out.print(nums[i] + " ");
		}
	}
	
	public static int findSmallest(int [] nums, int iteration)
	{
		int swapIndex = iteration;
		for (int j = iteration; j < nums.length; ++j)
		{
			if (nums[j] < nums[swapIndex])
			{
				swapIndex = j;
			}
		}
		return swapIndex;
	}
	
	public static void swapValues(int [] nums, int iteration)
	{
		int swapIndex = findSmallest(nums, iteration);
		int temp = nums[iteration];
		nums[iteration] = nums[swapIndex];
		nums[swapIndex] = temp;
	}
}
