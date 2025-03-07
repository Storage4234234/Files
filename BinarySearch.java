public class BinarySearch 
{
	public static int BinarySrch(int s[], int n)
	{
		int bot = 0;
		int top = s.length - 1;
		int mid = bot + (top - bot) / 2;
		
		while (s[mid] != n && top >= bot) 
		{
			if (s[mid] < n)
            {
                bot = mid + 1;
            }
            else 
            {
                top = mid - 1;
            }
            mid = bot + (top - bot) / 2;
		}
		
		if (s[mid] == n)
			return mid;
		else
			return -1;
	}
	
	public static void main(String [] args)
	{
		int initial = 5;
		int [] nums = new int [10];
		int pos = 0;
		
		for (int i = 1; i < nums.length + 1; i++)
		{
			nums[i-1] = initial * i;
		}
		
		pos = BinarySrch(nums, 50);
		
		if (pos != -1)
		{
			System.out.print("The number was found at index " + pos + " of the set.");
		}
		else
		{
			System.out.print("The number was not in the set.");
		}
	}
}
