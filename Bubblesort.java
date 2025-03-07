
public class Bubblesort 
{
	public static void main(String [] args)
	{
		int [] numbers = new int [10];
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = (int) (Math.random() * 1000) + 1;
		}
		for (int i = 0; i < numbers.length; i++)
		{
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		
		int swapCounter = 1;
		while (swapCounter != 0)
		{
			for (int currentIndex = 0; currentIndex < numbers.length - 1; currentIndex++)
			{
				if (numbers[currentIndex] > numbers[currentIndex + 1])
				{
					swapCounter = 1;
					int indexValue = numbers[currentIndex];
					numbers[currentIndex] = numbers[currentIndex + 1];
					numbers[currentIndex + 1] = indexValue;
					swapCounter++;
				}
			}
			swapCounter -= 1;
		}
		for (int i = 0; i < numbers.length; i++)
		{
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}
}
