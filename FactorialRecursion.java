public class FactorialRecursion 
{	
	static int input = 4;
	static int result = 1;
	static String phrase = "testing";
	static String finalString = "";
	static int charsLeft = phrase.length() - 1;
	
	public static int factorial(int i)
	{
		result *= input;
		if (input > 1)
		{
			FactorialRecursion.factorial(input -= 1);
		}
		return result;
	}
	
	public static String reverse(String i, int c)
	{
		finalString += phrase.charAt(c);
		if (charsLeft > 0)
		{
			reverse(phrase, charsLeft -= 1);
		}
		return finalString;
	}
	
	public static void main (String [] args)
	{	
		System.out.println(factorial(input));
		System.out.println(reverse(phrase, charsLeft));
	}
}
