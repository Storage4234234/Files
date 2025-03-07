import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RandomDots 
{

	private int height = 800;
	private int width = 1000;
	private Color [] colours = new Color[8];
	private JFrame dotWindow = new JFrame ("Dot Window");
	private JPanel drawingArea = new JPanel();
	private JButton clicker = new JButton ("Click Me");
	private Drawer makeDots = new Drawer();

	public RandomDots ()
	{
		colours[0] = Color.green;
		colours[1] = Color.blue;
		colours[2] = Color.red;
		colours[3] = Color.yellow;
		colours[4] = Color.magenta;
		colours[5] = Color.pink;
		colours[6] = Color.white;
		colours[7] = Color.orange;

		dotWindow.addWindowListener (new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		drawingArea.setBackground(Color.black);
		dotWindow.add(drawingArea,BorderLayout.CENTER);
		dotWindow.add(clicker, BorderLayout.SOUTH);
		clicker.addActionListener(makeDots);
		dotWindow.setSize(width,height);
		dotWindow.setVisible(true);
	}

	public class Drawer implements ActionListener
	{
		public void actionPerformed (ActionEvent e)

		{

			drawDots();

		}
	}

	public void drawDots() 
	{
		int c, x, y;
		Graphics2D g = (Graphics2D) drawingArea.getGraphics();

		for (int i = 0; i < 500; i++)
		{
			c = (int) (Math.random() * 8);
			x = (int) (Math.random() * width);
			y = (int) (Math.random() * height);

			g.setColor(colours[c]);
			g.fillRect(x, y, 5, 5);

		}
	}

	public static void main(String [] args)
	{
		RandomDots myWindow = new RandomDots();
		myWindow.drawDots();
	}
}

