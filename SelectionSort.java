public class SelectionSort
{
	public static void main(String [] args)
	{
		int [] nums = new int [10];
		int swapIndex;
		
		for (int i = 0; i < nums.length; i++)
		{
			nums[i] = (int) (Math.random() * 301) + 200;
		}
		
		for (int i = 0; i < nums.length - 1; ++i)
		{
			swapIndex = i;
			for (int j = i; j < nums.length; ++j)
			{
				if (nums[j] < nums[swapIndex])
				{
					swapIndex = j;
				}
			}
			
			int temp = nums[i];
			nums[i] = nums[swapIndex];
			nums[swapIndex] = temp;
		}
		
		for (int i = 0; i < nums.length; ++i)
		{
			System.out.println(nums[i]);
		}
	}
}