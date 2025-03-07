import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;

public class UserInput
{
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	
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
				MyGame().start();
			}
		}
	}
}
