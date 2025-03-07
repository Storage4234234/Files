import java.io.*;

public class DecimalToBinary 
{
	public static void main(String [] arg) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int decimalNumber = 0;
		String binaryNumber = "";
		int remainder = 0;
		
		System.out.print("Enter a decimal number: ");
		decimalNumber = Integer.parseInt(br.readLine());
		
		while (decimalNumber != 0)
		{
			remainder = decimalNumber % 2;
			decimalNumber /= 2;
			
			if (remainder == 1) 
			{
				binaryNumber = String.join("", "1", binaryNumber);
			}
			else
			{
				binaryNumber = String.join("", "0", binaryNumber);
			}
		}
		
		for (int leadingZeros = binaryNumber.length() % 4; leadingZeros > 0; leadingZeros--)
		{
			binaryNumber = String.join("", "0", binaryNumber);
		}
		
		for (int counter = binaryNumber.length() - 1; counter > 0; counter--)
		{
			if ((counter + 1) % 4 == 0)
			{
				binaryNumber = String.join(" ", binaryNumber.replaceAll(" ", "").substring(0, counter + 1), binaryNumber.replaceAll(" ", "").substring(counter + 1));
				System.out.println(binaryNumber);
			}
		}
		
		System.out.println("Your number in binary is " + binaryNumber);
	}
}
