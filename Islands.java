public class Islands
{
	public int [][] genMap(int l, int w)
	{
		int [][] array = new int [l][w];
		for (int i = 0; i < l; i++)
		{
			for (int j = 0; j < w; j++)
			{
				int temp = (int) (Math.random() * 100);
				if (temp > 25)
					array[i][j] = 0;
				else
					array[i][j] = 1;
			}
		}
		return array;
	}
	
	public void printGrid(int [][] grid) 
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
	
	public int countIslands(int [][] grid)
	{
		int numIslands = 0;
		
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j] == 1)
				{
					numIslands++;
					grid[i][j] = 0;
					
					grid = clearIsland(i, j, grid);
				}
			}
		}
		
		return numIslands;
	}
	
	public int [][] clearIsland(int i, int j, int [][] grid)
	{
		for (int k = i - 1; k <= i + 1; k++)
		{
			for (int l = j - 1; l <= j + 1; l++)
			{
				try
				{
					if (grid[k][l] == 1)
					{
						grid[k][l] = 0;
						grid = clearIsland(k, l, grid);
					}
				}
				catch (Exception e){}
			}
		}
		
		return grid;
	}
	
	public static void main (String [] args)
	{
		Islands test = new Islands();
		
		int [][] map = test.genMap(8, 8);
		test.printGrid(map);
		System.out.println();
		System.out.println(test.countIslands(map));
	}
}
