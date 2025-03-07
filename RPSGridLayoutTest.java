import java.awt.BorderLayout;

import java.awt.Image;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RPSGridLayoutTest 
{
	JFrame RockPaperScissors;
	JPanel gameArea;
	JPanel infoArea;
	JPanel inputArea;
	JPanel resultArea;
	JPanel duelArea;
	JLabel playerName;
	JLabel playerScore;
	JLabel oppName;
	JLabel oppScore;
	JLabel result;
	JLabel playerMove;
	JLabel computerMove;
	JButton [] actions;
	ImageIcon rock;
	Image rockScaler;
	ImageIcon paper;
	Image paperScaler;
	ImageIcon scissors;
	Image scissorsScaler;
	
	
	public RPSGridLayoutTest() throws IOException
	{	
		RockPaperScissors = new JFrame("Rock Paper Scissors");
		
		gameArea = new JPanel();
		infoArea = new JPanel();
		duelArea = new JPanel();
		inputArea = new JPanel();
		resultArea = new JPanel();
		
		playerName = new JLabel("Player");
		playerScore = new JLabel("0");
		oppName = new JLabel("Computer");
		oppScore = new JLabel("0");
		result = new JLabel();
		
		playerMove = new JLabel();
		computerMove = new JLabel();
		
		rock = findImage("THErock.jpg");
		rockScaler = rock.getImage();
		rockScaler = rockScaler.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
		rock = new ImageIcon(rockScaler);
		
		paper = findImage("payper.jpg");
		paperScaler = paper.getImage();
		paperScaler = paperScaler.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
		paper = new ImageIcon(paperScaler);
		
		scissors = findImage("scizzorzez.jpeg");
		scissorsScaler = scissors.getImage();
		scissorsScaler = scissorsScaler.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
		scissors = new ImageIcon(scissorsScaler);
		
		actions = new JButton [3];
		actions[0] = new JButton(rock);
		actions[1] = new JButton(paper);
		actions[2] = new JButton(scissors);
		actions[0].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {playRound(0);}});
		actions[1].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {playRound(1);}});
		actions[2].addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {playRound(2);}});
		
		RockPaperScissors.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		infoArea.setLayout(new GridLayout(2, 2));
		infoArea.add(playerName, BorderLayout.CENTER);
		infoArea.add(oppName, BorderLayout.CENTER);
		infoArea.add(playerScore, BorderLayout.CENTER);
		infoArea.add(oppScore, BorderLayout.CENTER);
		
		duelArea.setLayout(new GridLayout(1, 2));
		duelArea.add(playerMove);
		duelArea.add(computerMove);
		
		inputArea.setLayout(new GridLayout(1, 3));
		inputArea.add(actions[0]);
		inputArea.add(actions[1]);
		inputArea.add(actions[2]);
		
		resultArea.add(result);
		
		gameArea.setLayout(new GridLayout(4, 1));
		gameArea.add(infoArea);
		gameArea.add(duelArea);
		gameArea.add(inputArea);
		gameArea.add(resultArea);
		
		RockPaperScissors.add(gameArea, BorderLayout.CENTER);
		RockPaperScissors.setSize(800, 800);
		RockPaperScissors.setVisible(true);
	}
	
	public void playRound(int playerChoice)
	{
		int computerChoice = (int) (Math.random() * 3);
		
		result.setText("");
		playerMove.setIcon(actions[playerChoice].getIcon());
		computerMove.setIcon(actions[computerChoice].getIcon());
		
		if (computerChoice + 1 == playerChoice || computerChoice == 2 && playerChoice == 0)
		{
			playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) + 1));
		}
		else if(computerChoice == playerChoice)
		{
		}
		else
		{
			oppScore.setText(String.valueOf(Integer.parseInt(oppScore.getText()) + 1));
		}
		
		if (playerScore.getText().equals("2") || oppScore.getText().equals("2"))
		{
			playerScore.setText("0");
			oppScore.setText("0");
			gameEnd(true);
		}
	}
	
	public void gameEnd(boolean winner)
	{
		if (winner)
			result.setText("You Win!");
		else
			result.setText("You Lose!");
	}
	
	public ImageIcon findImage(String file) throws IOException
	{
		return new ImageIcon("resources/" + file);
	}
	
	public static void main (String [] args) throws IOException
	{
		new RPSGridLayoutTest();
	}
}
