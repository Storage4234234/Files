
public class Penguin
{
	private String name;
	private int age;
	private String colour;
	
	public Penguin()
	{
		name = "";
		age = 0;
		colour = "";
	}
	
	public Penguin(String n)
	{
		name = n;
		age = 0;
		colour = "";
	}
	
	public Penguin(String n, int a)
	{
		name = n;
		setAge(a);
		colour = "";
	}
	
	public Penguin (String n, int a, String c)
	{
		name = n;
		setAge(a);
		setColour(c);
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAge(int a)
	{
		if (a > -1)
		{
			age = a;
		}
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setColour(String c)
	{
		if (c.equalsIgnoreCase("brown") | c.equalsIgnoreCase("yellow") | c.equalsIgnoreCase("green"))
		{
			colour = c;
		}
		else
		{
			colour = "black";
		}
	}
	
	public String getColour()
	{
		return colour;
	}
	
	public void squawk()
	{
		System.out.println("Squawk");
	}
	
	public void swim(int heading, int distance)
	{
		System.out.println(name + " is swimming " + distance + "m at a heading of " + heading + " degrees");
	}
	
	public boolean eat (String food)
	{
		return food == "fish";
	}
}
