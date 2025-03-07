public class BucketSort
{
	public int [] genList(int length)
	{
		int [] list = new int [length];
		
		for (int i = 0; i < length; i++)
		{
			list[i] = (int) (Math.random() * 2000) - 1000;
		}
		
		return list;
	}
	
	public int [] sortList(int [] list)
	{
		int [][][] sortingGrid;
		int multiplier = 1;
		int check;
		int numPos;
		int numNeg;
		int counter;
		int digit;
		boolean isDone = false;
		
		while (!isDone)
		{
			sortingGrid = new int [2][10][list.length];
			check = 0;
			numPos = 0;
			counter = 0;
			
			for (int i = 0; i < list.length; i++)
			{
				digit = Math.abs(list[i] % (10 * multiplier) / multiplier);
				
				sortingGrid[0][digit][i] = list[i];
				
				if (list[i] < 0)
				{
					sortingGrid[1][digit][i] = -1;
				}
				else
				{
					sortingGrid[1][digit][i] = 1;
					numPos++;
				}
			}
			
			for (int i = 9; i >= 0; i--)
			{
				for (int j = 0; j < list.length; j++)
				{
					if (sortingGrid[1][i][j] == -1)
					{
						list[counter++] = sortingGrid[0][i][j];
						check += i;
					}
				}
			}
			
			for (int i = 0; i < list.length; i++)
			{
				for (int j = 0; j < list.length; j++)
				{
					if (sortingGrid[1][i][j] == 1)
					{
						list[list.length - numPos--] = sortingGrid[0][i][j];
						check += i;
					}
				}
			}
			
			if (check == 0)
				isDone = true;
			
			multiplier *= 10;
		}
		return list;
	}
	
	public String printList(int [] input)
	{
		String output = "";
		
		for (int i = 0; i < input.length; i++)
		{
			output = output + String.valueOf(input[i]) + " ";
		}
		return output;
	}
	
	public static void main(String [] args)
	{
		BucketSort sorter = new BucketSort();
		
		int [] list = sorter.genList(10);
		System.out.println(sorter.printList(list));
		sorter.sortList(list);
		System.out.println(sorter.printList(list));
	}
}
