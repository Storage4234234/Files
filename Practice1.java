import java.io.*;

public class Practice1
{
	public static void main (String [] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Say something: ");
		String words = br.readLine();
		
		if (words.toLowerCase().contains("e"))
		{
			System.out.print("Yes");
		}
		else 
		{
			System.out.print("No");
		}
		
		/*int firstNumber, secondNumber, result = 0;
		float dividend = 0;
		char operation = ' ';
		
		System.out.print("Enter a single digit number: ");
		firstNumber = Integer.parseInt(br.readLine());
		
		System.out.print("Enter the operation you would like to perform: ");
		operation = (char) br.read();
		
		System.out.print("Enter another single digit number ");
		secondNumber = Integer.parseInt(br.readLine());
		
		if (operation == '+')
		{
			result = firstNumber + secondNumber;
		}
		else if (operation == '-')
		{
			result = firstNumber - secondNumber;
		}
		else if (operation == '*')
		{
			result = firstNumber * secondNumber;
		}
		else if (operation == '/')
		{
			dividend = (float) firstNumber / secondNumber;
		}
		
		if (result == 0)
		{
			System.out.println(dividend);
		}
		else
		{
			System.out.println(result);
		}*/
		
	}
}
