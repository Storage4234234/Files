import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class RPNCalculator 
{
	CalculatorStack memory;
	JFrame calculator;
	JPanel container;
	JPanel display;
	JPanel input;
	JLabel expression;
	JButton [] buttons;
	InputMap im;
	ActionMap am;
	boolean enteredLast;
	
	public RPNCalculator()
	{
		memory = new CalculatorStack();
		
		calculator = new JFrame("RPN Calculator");
		
		container = new JPanel();
		display = new JPanel();
		input = new JPanel();
		
		expression = new JLabel();
		
		buttons = new JButton[20];
		buttons[0] = new JButton("0");
		buttons[1] = new JButton("1");
		buttons[2] = new JButton("2");
		buttons[3] = new JButton("3");
		buttons[4] = new JButton("4");
		buttons[5] = new JButton("5");
		buttons[6] = new JButton("6");
		buttons[7] = new JButton("7");
		buttons[8] = new JButton("8");
		buttons[9] = new JButton("9");
		buttons[10] = new JButton(".");
		buttons[11] = new JButton("+");
		buttons[12] = new JButton("-");
		buttons[13] = new JButton("*");
		buttons[14] = new JButton("/");
		buttons[15] = new JButton("^");
		buttons[16] = new JButton("√");
		buttons[17] = new JButton("Enter");
		buttons[18] = new JButton("Clear");
		buttons[19] = new JButton("Delete");
		
		buttons[0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("0");}});
		buttons[1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("1");}});
		buttons[2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("2");}});
		buttons[3].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("3");}});
		buttons[4].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("4");}});
		buttons[5].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("5");}});
		buttons[6].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("6");}});
		buttons[7].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("7");}});
		buttons[8].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("8");}});
		buttons[9].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("9");}});
		buttons[10].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression(".");}});
		buttons[11].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("+");}});
		buttons[12].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("-");}});
		buttons[13].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("*");}});
		buttons[14].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("/");}});
		buttons[15].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("^");}});
		buttons[16].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("√");}});
		buttons[17].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("enter");}});
		buttons[18].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("clear");}});
		buttons[19].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {modifyExpression("delete");}});
		
		im = container.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		am = container.getActionMap();
		
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0, false), "0");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false), "1");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, false), "2");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, false), "3");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, false), "4");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0, false), "5");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0, false), "6");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0, false), "7");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0, false), "8");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0, false), "9");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0, false), ".");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.SHIFT_DOWN_MASK, false), "+");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0, false), "-");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_8, KeyEvent.SHIFT_DOWN_MASK, false), "*");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0, false), "/");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_6, KeyEvent.SHIFT_DOWN_MASK, false), "^");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.SHIFT_DOWN_MASK, false), "!");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "enter");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0, false), "delete");

	    am.put("0", new KeyInput("0"));
	    am.put("1", new KeyInput("1"));
	    am.put("2", new KeyInput("2"));
	    am.put("3", new KeyInput("3"));
	    am.put("4", new KeyInput("4"));
	    am.put("5", new KeyInput("5"));
	    am.put("6", new KeyInput("6"));
	    am.put("7", new KeyInput("7"));
	    am.put("8", new KeyInput("8"));
	    am.put("9", new KeyInput("9"));
	    am.put(".", new KeyInput("."));
	    am.put("+", new KeyInput("+"));
	    am.put("-", new KeyInput("-"));
	    am.put("*", new KeyInput("*"));
	    am.put("/", new KeyInput("/"));
	    am.put("^", new KeyInput("^"));
	    am.put("!", new KeyInput("!"));
	    am.put("enter", new KeyInput("enter"));
	    am.put("delete", new KeyInput("delete"));
		
		calculator.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		display.add(expression);
		
		input.setLayout(new GridLayout(5,4));
		for (int i = 0; i < buttons.length; i++)
		{
			input.add(buttons[i]);
		}
		
		container.setLayout(new GridLayout(2,1));
		container.add(display);
		container.add(input);
		container.setFocusable(true);
		
		calculator.setSize(500, 800);
		calculator.add(container, BorderLayout.CENTER);
		calculator.setVisible(true);
		enteredLast = false;
	}
	
	public void modifyExpression(String buttonPressed)
	{
		if (buttonPressed.equals("clear"))
		{
			expression.setText("");
			for (int i = 0; i <= memory.getTop(); i++)
			{
				memory.pop();
			}
			enteredLast = false;
		}
		else if (buttonPressed.equals("delete"))
		{
			expression.setText("");
			enteredLast = false;
		}
		else if (buttonPressed.equals("enter"))
		{
			if (expression.getText().endsWith("+") || expression.getText().endsWith("-") || expression.getText().endsWith("*") || expression.getText().endsWith("/") || expression.getText().endsWith("^") || expression.getText().endsWith("√"))
			{
				expression.setText(String.valueOf(compute(expression.getText(), memory)));
				enteredLast = true;
			}
			else
			{
				if (enteredLast)
					expression.setText("Invalid Input");
				memory.push(Float.parseFloat(expression.getText()));
				enteredLast = true;
			}
		}
		else
		{
			if (enteredLast)
			{
				expression.setText("");
				enteredLast = false;
			}
			expression.setText(expression.getText() + buttonPressed);
		}
	}
	
	public float compute(String input, CalculatorStack stack)
	{
		float result = Float.NaN;
		try
		{	
			String operator = String.valueOf(input.charAt(input.length() - 1));
			float value = Float.parseFloat(input.replace(operator, "").trim());
			
			if (operator.equals("+"))
			{
				float right = value;
				float left = memory.pop();
				result = left + right;
			}
			else if (operator.equals("-"))
			{
				float right = value;
				float left = memory.pop();
				result = left - right;
			}
			else if (operator.equals("*"))
			{
				float right = value;
				float left = memory.pop();
				result = left * right;
			}
			else if (operator.equals("/"))
			{
				float right = value;
				float left = memory.pop();
				result = left / right;
			}
			else if (operator.equals("^"))
			{
				float power = value;
				float base = memory.pop();
				result = (float) Math.pow(base, power);
			}
			else if (operator.equals("√"))
			{
				float power = value;
				float base = memory.pop();
				result = (float) Math.pow(base, 1 / power);
			}
			
			memory.push(result);
		}
		catch (Exception e)
		{
			return Float.NaN;
		}
		
		try
		{
			memory.pop();
			memory.pop();
			return Float.NaN;
		}
		catch (Exception e)
		{
			return result;
		}
	}
	
	public class KeyInput extends AbstractAction
	{
		private String input;
		
		public KeyInput(String command)
		{
			input = command;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			modifyExpression(input);
		}
	}
	
	public static void main (String [] args) throws Exception
	{	
		new RPNCalculator();
	}
}
