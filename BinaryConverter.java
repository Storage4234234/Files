import java.io.*;

public class BinaryConverter
{
	public static void main (String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String binaryNumber = "";
		int decimalNumber = 0;
		int decimalNumber2 = 0;
		
		System.out.print("Enter a number in binary: ");
		binaryNumber = br.readLine();
		binaryNumber = binaryNumber.replaceAll(" ", "");
		
		int multiplier = (int) Math.pow(2, binaryNumber.length() - 1);
		
		for (int currentIndex = 0; currentIndex < binaryNumber.length(); currentIndex++)
		{	
			if (binaryNumber.charAt(currentIndex) == '1')
			{
				decimalNumber += multiplier;
			}
			
			multiplier /= 2;

		}
		
		for (int currentIndex = binaryNumber.length() - 1; currentIndex > -1; currentIndex--)
		{	
			if (binaryNumber.charAt(currentIndex) == '1')
			{
				decimalNumber2 += Math.pow(2, -1 - currentIndex + binaryNumber.length());
			}
		}
			
		System.out.println("Your number in base 10 is " + decimalNumber);
		System.out.println("Your number in base 10 is " + decimalNumber2);
	}
}
