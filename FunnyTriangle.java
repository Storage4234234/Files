public class FunnyTriangle
{
	public static int [][] genPascal(int n)
	{
		int [][] pascalTriangle = new int [n][n * 2 + 1];
		pascalTriangle[0][n] = 1;
		
		for (int row = 1; row < n; row++)
		{
			for (int col = 0; col < n * 2 + 1; col++)
			{
				try
				{
					pascalTriangle[row][col] = pascalTriangle[row - 1][col - 1] + pascalTriangle[row - 1][col + 1];
				}
				catch (Exception e)
				{
					pascalTriangle[row][col] = 0;
				}
			}
		}
		return pascalTriangle;
	}
	
	public static void printTriangle(int [][] array)
	{
		int length = array.length * 2 + 1;
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < length; j++)
			{
				if (array[i][j] == 0)
					System.out.printf("%3s", " ");
				else
					System.out.printf("%3d", array[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main (String [] args)
	{
		int [][] triangle = genPascal(8);
		printTriangle(triangle);
	}
}
