import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class DisplayNotFail extends JFrame implements ActionListener {
	boolean isRunning = false;
	JButton play = new JButton("Start");
	JButton nextGen = new JButton("Next Generation");
	JButton prevGen = new JButton("Previous Generation");
	JPanel board = new JPanel();
	public void paint(Graphics g)
	{
		int width = board.getWidth();
		int height = board.getHeight();
		int boxSize = 10;
		board.paint(g);
		Graphics2D g2 =(Graphics2D)g;
		for(int i = 1; boxSize * i < height; i+= boxSize)
		{
			int startY = 1;
			int startX = i * (width / boxSize);
			g.drawLine(startX, startY, startX , height);
			
		}
	}
	DisplayNotFail() {
		board.setPreferredSize(new Dimension(500, 500));
		board.setLayout(null);
		board.setLocation(100, 100);
		int borderWidth = 1;
		int boardSize = 50;
		boolean isRunning = false;
		GameOfLife life = new GameOfLife(boardSize);
		JLabel genNum = new JLabel("" + life.getGenerationNum());
		ArrayList<JButton> cells = new ArrayList<JButton>();
		this.setPreferredSize(new Dimension(1000, 1000));
		play.addActionListener(this);
		play.setActionCommand("play");
		nextGen.addActionListener(this);
		nextGen.setActionCommand("next");
		prevGen.addActionListener(this);
		prevGen.setActionCommand("prev");
		board.repaint();
		this.add(board);
		//this.add(prevGen);
		//this.add(nextGen);
		//this.add(play);
		this.pack();

	}

	public void actionPerformed(ActionEvent e)
	{
/*		String command = e.getActionCommand();
		if(command.equals("play"))
		{
			if(isRunning = false)
			play.setText("Pause");
			
			if(isRunning == false)
				play.setText("Play");
			
		}
		if(command.equals("next"))
				{
			
				}
		{
			
		}
		if(command.equals("prev"))
		{
			
		}*/
	}

	public static void main(String[] args) {
		DisplayNotFail test = new DisplayNotFail();
		test.setVisible(true);

	}
}
