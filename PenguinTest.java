
public class PenguinTest
{
	public static void main(String [] args)
	{
		Penguin penguin;
		penguin = new Penguin("Test Subject 1", 10);
		
		Penguin penguin2 = new Penguin("Test Subject 2", 20);
		Penguin penguin3 = new Penguin("Test Subject 3", 30, "orange");
		
		penguin.squawk();
		penguin.swim(90, 10);
		penguin2.swim(90, 10);
		
		System.out.println(penguin.getAge());
		System.out.println(penguin2.getAge());
		System.out.println(penguin3.getColour());
	}
}
