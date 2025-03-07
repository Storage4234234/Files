public class RecursionTypeSh
{
	public static void main(String [] args)
	{
		System.out.println(fibonacciSequence(5));
		//printNum(10);
	}
	/*
	public static void printNum(int n)
	{
		System.out.println(n);
		if(n > 0)
		{
		printNum(n-1);
		}
		System.out.println(n);
	}
	*/
	public static int fibonacciSequence(int n)
	{
		if (n > 2)
		{
			return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
		}
		else
		{
			return 1;
		}
	}
}

