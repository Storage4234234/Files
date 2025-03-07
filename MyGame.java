import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class MyGame
{
	private int height = 900;
	private int width = 1450;
	private int maxEnemies = 3;
	private int numEnemies = 1;
	private int score = 0;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private BufferedImage playerIcon;
	private BufferedImage objectiveIcon;
	private BufferedImage enemyIcon;
	private BufferedImage endScreen;
	private Color background = new Color(171,219,227);
	private JFrame gameWindow = new JFrame ("My Game");
	private JPanel playingArea = new JPanel();
	private Obstacle [] enemies = new Obstacle[maxEnemies];
	private Location [] particles = new Location[150];
	private Obstacle objective = new Obstacle(new Location((int) (Math.random() * (width - 60)), (int) (Math.random() * (height - 75))), 60, 75);
	private Player player = new Player();
	private ActionListener gameLoop = new ActionListener() {public void actionPerformed(ActionEvent timerDone) {createFrame();}};
	private Timer frameRate = new Timer(15, gameLoop);
	

	public MyGame() throws IOException
	{	
		gameWindow.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		playingArea.setBackground(Color.black);
		gameWindow.add(playingArea, BorderLayout.CENTER);
		playingArea.setFocusable(true);
		gameWindow.setSize(width,height);
		gameWindow.setVisible(true);
		menuScreen();
		frameRate.setRepeats(true);
		enemies [0] = new Obstacle(new Location(500, 500));
		playerIcon = getImage("penguin.png");
		objectiveIcon = getImage("salmon.png");
		enemyIcon = getImage("bear.png");
		endScreen = getImage("endscreen.png");
		
		for (int i = 0; i < particles.length; i++)
		{
			particles[i] = new Location((int) (Math.random() * width), (int) (Math.random() * height));
		}
		
		InputMap im = playingArea.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
	    ActionMap am = playingArea.getActionMap();
	    
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "RightArrowPressed");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "LeftArrowPressed");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "UpArrowPressed");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "DownArrowPressed");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "SpaceBarPressed");
	    
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightArrowReleased");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftArrowReleased");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UpArrowReleased");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DownArrowReleased");

	    am.put("RightArrowPressed", new Controls("rightpr"));
	    am.put("LeftArrowPressed", new Controls("leftpr"));
	    am.put("UpArrowPressed", new Controls("uppr"));
	    am.put("DownArrowPressed", new Controls("downpr"));
	    am.put("SpaceBarPressed", new Controls("spacepr"));
	    
	    am.put("RightArrowReleased", new Controls("rightre"));
	    am.put("LeftArrowReleased", new Controls("leftre"));
	    am.put("UpArrowReleased", new Controls("upre"));
	    am.put("DownArrowReleased", new Controls("downre"));
	}
	
	public BufferedImage getImage(String file) throws IOException
	{
		return ImageIO.read(new File("GameAssets/" + file));
	}
	
	public void menuScreen()
	{
		Graphics2D g = (Graphics2D) playingArea.getGraphics();
		
		g.setColor(Color.white);
		g.setFont(new Font("Apple Gothic", Font.PLAIN, 50));
		g.drawString("Press 'SPACE' to Start", 470, 400);
		g.setFont(new Font("Apple Gothic", Font.PLAIN, 25));
		g.drawString("Please Enter Fullscreen", 585, 450);
	}
	
	public void start()
	{
		frameRate.start();
	}
	
	public void gameOver()
	{
		Graphics2D g = (Graphics2D) playingArea.getGraphics();
		g.drawImage(endScreen, 0, 0, width, height, playingArea);
		g.setFont(new Font("Apple Gothic", Font.PLAIN, 40));
		g.setColor(Color.white);
		g.drawString("Final Score: " + String.valueOf(score), 585, 700);
		frameRate.stop();
	}
	
	public boolean checkOverlap(Obstacle o)
	{
		if (o.getLocation().getX() > player.getLocation().getX() + player.getWidth()
		|| o.getLocation().getY() > player.getLocation().getY() + player.getHeight()
		|| player.getLocation().getX() > o.getLocation().getX() + o.getWidth()
		|| player.getLocation().getY() > o.getLocation().getY() + o.getHeight())
			return false;
		return true;
	}
	
	private boolean isAlive()
	{
		for (int i = 0; i < numEnemies; i++)
		{
			if (checkOverlap(enemies[i]))
				return false;
		}
		return true;
	}
	
	private boolean itemPickup()
	{
		if (checkOverlap(objective))
		{
			score += 100;
			return true;
		}
		return false;
	}

	public void createFrame()
	{
		if (!isAlive())
		{
			gameOver();
		}
		else
		{
			if (up)
			{
				player.veloChangeY(-3);
			}
			if (down)
			{
				player.veloChangeY(3);
			}
			if (left)
			{
				player.veloChangeX(-3);
			}
			if (right)
			{
				player.veloChangeX(3);
			}
			if (player.getVeloX() > 0)
			{
				player.veloChangeX((float) -0.25);
			}
			else if (player.getVeloX() < 0)
			{
				player.veloChangeX((float) 0.25);
			}
			if (player.getVeloY() > 0)
			{
				player.veloChangeY((float) -0.25);
			}
			else if (player.getVeloY() < 0)
			{
				player.veloChangeY((float) 0.25);
			}
			player.moveX(player.getVeloX());
			player.moveY(player.getVeloY());
			
			if (itemPickup())
			{
				objective.getLocation().setX((int) (Math.random() * (width - objective.getWidth())));
				objective.getLocation().setY((int) (Math.random() * (height - objective.getHeight())));
			}
			
			if (score == 1000 && numEnemies == 1)
			{
				enemies[numEnemies] = new Obstacle();
				numEnemies += 1;
			}
			else if (score == 2000 && numEnemies == 2)
			{
				enemies[numEnemies] = new Obstacle();
				numEnemies += 1;
			}
			
			for (int i = 0; i < numEnemies; i++)
			{
				if (enemies[i].isFinished())
					enemies[i].rollDestination();
				else
					enemies[i].chase();
			}
			
			drawScreen();
		}
	}
	
	public void drawScreen() 
	{
		Graphics2D g = (Graphics2D) playingArea.getGraphics();

		g.setColor(background);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.white);
		for (int i = 0; i < particles.length; i++)
		{
			g.fillRect(particles[i].getX(), particles[i].getY(), 5, 5);
		}	
		
		for (int i = 0; i < numEnemies; i++)
		{
			g.drawImage(enemyIcon, enemies[i].getLocation().getX(), enemies[i].getLocation().getY(), enemies[i].getWidth(), enemies[i].getHeight(), playingArea);
		}	
		g.drawImage(playerIcon, player.getLocation().getX(), player.getLocation().getY(), player.getWidth(), player.getHeight(), playingArea);
		g.drawImage(objectiveIcon, objective.getLocation().getX(), objective.getLocation().getY(), objective.getWidth(), objective.getHeight(), playingArea);

		g.setFont(new Font("Apple Gothic", Font.PLAIN, 20));
		g.drawString("Score: " + String.valueOf(score), 0, 20);
	}
	
	public class Controls extends AbstractAction
	{
		private String input;
		
		public Controls(String command)
		{
			input = command;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if (input == "uppr")
			{
				up = true;
			}
			else if (input == "downpr")
			{
				down = true;
			}
			else if (input == "leftpr")
			{
				left = true;
			}
			else if (input == "rightpr")
			{
				right = true;
			}
			else if (input == "upre")
			{
				up = false;
			}
			else if (input == "downre")
			{
				down = false;
			}
			else if (input == "leftre")
			{
				left = false;
			}
			else if (input == "rightre")
			{
				right = false;
			}
			else if (input == "spacepr")
			{
				start();
			}
		}
	}
	
	public static void main(String [] args) throws IOException
	{
		new MyGame();
	}
	
}