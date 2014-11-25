import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;



public class DisplayNotFail extends JFrame implements ActionListener {
	boolean isRunning = false;
	
	DisplayNotFail()
	{
	int borderWidth = 1;
	int boardSize = 50;
	boolean isRunning = false;
	GameOfLife life = new GameOfLife(boardSize);
	JLabel genNum = new JLabel("" + life.getGenerationNum());
	ArrayList<JButton> cells = new ArrayList<JButton>();
	this.setPreferredSize(new Dimension(1000,1000));
	JButton play = new JButton("Start");
	JButton nextGen = new JButton("Next Generation");
	JButton prevGen = new JButton("Previous Generation");
	
	this.add(prevGen);
	this.add(nextGen);
	this.add(play);
	this.pack();
	
	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	public static void main(String[] args)
	{
		DisplayNotFail test = new DisplayNotFail();
		test.setVisible(true);
	
	}
}
