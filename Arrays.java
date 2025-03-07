import java.io.*;

public class Arrays
{
	public static void main(String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [] archibald = {5, 2, 3, 4, 5, 15, 4, 3, 8, 16};
		int [] fitzgerald = new int [10];
		int [] archigerald = new int [10];
		char [] bartholomew = new char [10];
		String [] jerry = {"orange", "yellow", "blue", "green", "red"};
		
		for (int i = 0; i < archibald.length; i++)
		{
			System.out.print(archibald[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < fitzgerald.length; i++)
		{
			fitzgerald[i] = (int) (Math.random() * 100) + 1;
		}
		
		for (int i = 0; i < fitzgerald.length; i++)
		{
			System.out.print(fitzgerald[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < archigerald.length; i++)
		{
			archigerald[i] = archibald[i] + fitzgerald[i];
		}
		
		for (int i = 0; i < archigerald.length; i++)
		{
			System.out.print(archigerald[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < bartholomew.length; i++)
		{
			int randomChar = (int) (Math.random() * 26) + 97;
			bartholomew[i] = (char) randomChar;
		}
		
		for (int i = 0; i < bartholomew.length; i++)
		{
			System.out.print(bartholomew[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < jerry.length; i++)
		{
			System.out.print(jerry[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < jerry.length; i++)
		{
			System.out.print(jerry[jerry.length - 1 - i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < jerry.length; i++)
		{
			System.out.print(jerry[(int) (Math.random() * 4)] + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.print("Enter a colour: ");
		String inputColour = br.readLine();
		
		int colourIndex;
		for (colourIndex = 0; colourIndex < jerry.length && !jerry[colourIndex].equalsIgnoreCase(inputColour); colourIndex++);
		
		if (colourIndex < jerry.length)
		{
			System.out.println("Your colour is number " + (colourIndex + 1) + " in the list.");
		}
		else
		{
			System.out.println("Your colour is not in the list.");
		}
	}
}
