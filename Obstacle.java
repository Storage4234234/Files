import java.awt.Color;

public class Obstacle 
{
	private Location location;
	private Location destination;
	private int height;
	private int width;
	
	public Obstacle()
	{
		location = new Location();
		destination = new Location();
		rollDestination();
		height = 80;
		width = 120;
	}
	
	public Obstacle (Location l)
	{
		location = l;
		destination = new Location();
		rollDestination();
		height = 80;
		width = 120;
	}
	
	public Obstacle(Location l, int h, int w)
	{
		location = l;
		destination = new Location();
		rollDestination();
		height = h;
		width = w;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public void setLocation(Location l)
	{
		location = l;
	}

	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public Location getDestination()
	{
		return destination;
	}
	
	public void rollDestination() 
	{
		destination.setX((int) (Math.random() * (1450 - width)));
		destination.setY((int) (Math.random() * (900 - height)));
	}
	
	public void chase()
	{
		if (destination.getX() > location.getX() && Math.abs(destination.getX() - location.getX()) > width)
			location.setX(location.getX() + 5);
		else if (destination.getX() < location.getX() && Math.abs(destination.getX() - location.getX()) > width)
			location.setX(location.getX() - 5);
		
		if (destination.getY() > location.getY() && Math.abs(destination.getY() - location.getY()) > height)
			location.setY(location.getY() + 5);
		else if (destination.getY() < location.getY() && Math.abs(destination.getY() - location.getY()) > height)
			location.setY(location.getY() - 5);
	}
	
	public boolean isFinished()
	{
		return Math.abs(destination.getX() - location.getX()) <= width && Math.abs(destination.getY() - location.getY()) <= height;
	}
}