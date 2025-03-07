import java.io.*;

public class OctalAndHexadecimalConverter 
{
	public static void main (String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String conversionType = "";
		String inputNumber = "";
		int decimalNumber = 0;
		
		System.out.print("Convert from octal or hexadecimal: ");
		conversionType = br.readLine();
		System.out.print("Enter the number you want to convert: ");
		inputNumber = br.readLine();
		inputNumber = inputNumber.replaceAll(" ", "");
		
		if (conversionType.equalsIgnoreCase("octal")) 
		{	
			for (int currentIndex = 0; currentIndex < inputNumber.length(); currentIndex++)
			{	
				decimalNumber += (inputNumber.charAt(currentIndex) - '0') * Math.pow(8, inputNumber.length() - currentIndex - 1);
			}
			
			System.out.println("Your octal number in base 10 is " + decimalNumber);
		}
		else if (conversionType.equalsIgnoreCase("hexadecimal") || conversionType.equalsIgnoreCase("hex")) 
		{
			for (int currentIndex = 0; currentIndex < inputNumber.length(); currentIndex++)
			{	
				if (inputNumber.charAt(currentIndex) < 58)
				{
					decimalNumber += (inputNumber.charAt(currentIndex) - '0') * Math.pow(16, inputNumber.length() - currentIndex - 1);
				}
				else
				{
					decimalNumber += (inputNumber.charAt(currentIndex) - '7') * Math.pow(16, inputNumber.length() - currentIndex - 1);
				}
			}
			
			System.out.println("Your hex number in base 10 is " + decimalNumber);
		}
		else
		{
			System.out.println("Invalid input");
		}
	}
}
