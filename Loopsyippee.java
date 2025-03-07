import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Loopsyippee
{
	public static void main (String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//int counter = 0;
		
/*		while (counter < 10)
		{
			System.out.println(counter);
			counter++;
		}
		
		for (counter = 10; counter > -1; counter--)
		{
			System.out.println(counter);
		}*/
		
		int row = 0;
		int column = 0;
		
/*		for (row = 0; row < 10; row++)
		{
			for (column = 0; column < 5; column++)
			{
				int result = row * column;
				System.out.print(result + " ");
			}
			System.out.println();
		}*/
		
/*		for (row = 0; row < 5; row++)
		{
			for (column = 0; column < 5; column++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (row = 0; row < 5; row++)
		{
			for (column = 0; column <= row; column++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (row = 0; row < 5; row++)
		{
			for (column = 5; row < column; column--)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println();*/
		
		System.out.print("Enter what you want to say: ");
		String userPhrase = br.readLine();
		
/*		System.out.print("Enter how many times you want it to repeat: ");
		int repeats = Integer.parseInt(br.readLine());
		
		int alreadyPrinted = 0;
		
		for (alreadyPrinted = 0; alreadyPrinted < repeats; alreadyPrinted++)
		{
			System.out.println(userPhrase);
		}*/
		
		for (row = 0; row < userPhrase.length(); row++)
		{
			for (column = 0; column <= row; column++)
			{
				System.out.print(userPhrase.charAt(column));
			}
			System.out.println();
		}
		
		for (row = 0; row < userPhrase.length(); row++)
		{
			for (column = userPhrase.length() - 1; row < column; column--)
			{
				System.out.print(userPhrase.charAt(userPhrase.length()));
			}
			System.out.println();
		}
		
	}
}
