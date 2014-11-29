import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class DisplayNotFail extends JFrame implements ActionListener, MouseListener {
	boolean isRunning = false;
	JButton play = new JButton("Start");
	JButton nextGen = new JButton("Next Generation");
	JButton prevGen = new JButton("Previous Generation");
	JPanel board = new JPanel();
	int row = 0;
	int col = 0;
	int width = board.getWidth();
	int height = board.getHeight();
	final int boxSize = 20;
	final int boardSize = 30;
	final int boardOffsetX = 200;
	final int boardOffsetY = 100;
	int x;
	int y;
	GameOfLife life = new GameOfLife(boardSize);
	Rectangle[][] cells = new Rectangle[boardSize][boardSize];
	Insets inset;

	public void paint(Graphics g) {
		inset = getInsets();
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		int width = board.getWidth();
		int height = board.getHeight();
		int x = 0;
		int y = 0;
		for (int across = boardOffsetX; across < boardOffsetX + (boardSize * boxSize); across += boxSize) {

			
			for (int down = boardOffsetY; down < boardOffsetY + (boardSize * boxSize); down += boxSize) {
				if(life.getBoard().board[x][y] == 0){
				cells[x][y] = new Rectangle(across, down, boxSize, boxSize);
						g2.drawRect(across, down, boxSize, boxSize);
				}
				else
				{
					cells[x][y] = new Rectangle(across, down, boxSize, boxSize);
							g2.fillRect(across, down, boxSize, boxSize);
			}
				y++;
				}
			y = 0;
			x++;
			
		}
	}

	DisplayNotFail() {
		board.setPreferredSize(new Dimension(500, 500));
		board.setLayout(null);
		board.setLocation(100, 100);
		board.addMouseListener(this);
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
		// this.add(prevGen);
		// this.add(nextGen);
		// this.add(play);
		this.pack();

	}

	public void actionPerformed(ActionEvent e) {
		/*
		 * String command = e.getActionCommand(); if(command.equals("play")) {
		 * if(isRunning = false) play.setText("Pause");
		 * 
		 * if(isRunning == false) play.setText("Play");
		 * 
		 * } if(command.equals("next")) {
		 * 
		 * } {
		 * 
		 * } if(command.equals("prev")) {
		 * 
		 * }
		 */
	}

	public static void main(String[] args) {
		DisplayNotFail test = new DisplayNotFail();
		test.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = (e.getX() - boardOffsetX) / boxSize;
		int y = (e.getY() - boardOffsetY) / boxSize;
		System.out.println(x + " " + y);
		if (life.getBoard().board[x][y] == 0)
		life.getBoard().board[x][y] = 1;
		else life.getBoard().board[x][y] = 0;
		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
