public class GridArray
{	
	public static void printGrid(int [][] grid) 
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args)
	{
		int [][] grid = new int [6] [6];
		int counter = 1;
		boolean vertical = false;
		
		for (int i = 0; i < grid.length * grid[0].length; i++)
		{
			for (int j = 0; j < 1; j++)
			{
				grid[j][i] = counter;
				counter++;
			}
		}
		
		printGrid(grid);
	}
}
