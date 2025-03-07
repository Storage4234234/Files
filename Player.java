import java.awt.Color;
import java.lang.Math;

public class Player 
{
	private Location location;
	private int height;
	private int width;
	private float veloX;
	private float veloY;
	private int maxSpeedX;
	private int maxSpeedY;
	
	public Player()
	{
		location = new Location();
		height = 100;
		width = 80;
		veloX = 0;
		veloY = 0;
		maxSpeedX = 15;
		maxSpeedY = 15;
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
	
	public float getVeloX()
	{
		return veloX;
	}
	
	public float getVeloY()
	{
		return veloY;
	}
	
	public void veloChangeX(float a)
	{
		veloX += a;
		if (Math.abs(veloX) > maxSpeedX)
		{
			veloX = (int) Math.copySign(maxSpeedX, veloX);
		}
	}
	
	public void veloChangeY(float a)
	{
		veloY += a;
		if (Math.abs(veloY) > maxSpeedY)
		{
			veloY = (int) Math.copySign(maxSpeedY, veloY);
		}
	}
	
	public void moveX(float v)
	{
		if(location.getX() + v >= 0 && location.getX() + v <= 1450 - width)
			location.setX((int) Math.floor(location.getX() + v));
		else if(location.getX() + v < 0)
		{
			location.setX(0);
			veloX *= -1;
		}
		else if(location.getX() + v > 1450 - width)
		{
			location.setX(1450 - width);
			veloX *= -1;
		}
	}
	
	public void moveY(float v)
	{
		if(location.getY() + v >= 0 && location.getY() + v <= 900 - height)
			location.setY((int) Math.floor(location.getY() + v));
		else if(location.getY() + v < 0)
		{
			location.setY(0);
			veloY *= -1;
		}
		else if(location.getY() + v > 900 -  height)
		{
			location.setY(900 - height);
			veloY *= -1;
		}
	}
}