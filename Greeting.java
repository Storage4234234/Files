import java.io.*;

public class Greeting
{
	public static void main (String [] args) throws Exception	
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x;
		int y = 3;
		int sum = 0;
		int dividend = 0;
		float answer = 0;
		char question = 'w';
		int counter = 0;
		char question1 = 'a';
		char question2 = 500;
		boolean attended = true;
		String weather = "rainy";
		String temperature = "mild";
		String weatherPhrase;
		String ifNotRainy = "rainy";
		int day = 0;
		
		x = 14;
		sum = x + y;
		dividend = x / y;
		answer = (float) x / y;
		counter += 2;
		counter++;
		counter -= 2; 
		counter--;
		question++;
		question1 += 5;
		weatherPhrase = weather + " " + temperature;
		weatherPhrase = weather + x;
		weatherPhrase = x + weather;
		weatherPhrase = weatherPhrase.replaceAll("y", "!");
		weatherPhrase = weatherPhrase.substring(2, 7);
		weatherPhrase = weatherPhrase.substring(weatherPhrase.indexOf("r"));
		weatherPhrase = weatherPhrase.substring(weatherPhrase.indexOf("r"), weatherPhrase.indexOf("!") + 1);
		
		System.out.println(x);
		System.out.println(sum);
		System.out.println(dividend);
		System.out.println(answer);
		System.out.println(question);
		System.out.println(question1);
		System.out.println(question2);
		System.out.println(counter);
		System.out.println(attended);
		System.out.println(!attended);
		System.out.println(weather);
		System.out.println(weatherPhrase);
		System.out.println(weather.charAt(2));
		System.out.println(weatherPhrase.indexOf("in"));
		System.out.println(weatherPhrase.replaceAll(ifNotRainy, "sunny"));
		System.out.println(weatherPhrase.replaceAll("n", "*"));
		
		System.out.print("Enter the day of the month: ");
		day = Integer.parseInt(br.readLine());
		System.out.println(day + 1);
	}
}
