import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class DisplayNotFail extends JFrame implements ActionListener,
		MouseListener {
	boolean isRunning = false;
	JPanel buttonBoard = new JPanel();
	JMenuItem play = new JMenuItem("Start");
	JMenuItem nextGen = new JMenuItem("Next Generation");
	JMenuItem prevGen = new JMenuItem("Previous Generation");
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
		for (int across = boardOffsetX; across < boardOffsetX
				+ (boardSize * boxSize); across += boxSize) {

			for (int down = boardOffsetY; down < boardOffsetY
					+ (boardSize * boxSize); down += boxSize) {
				if (life.getBoard().board[x][y] == 0) {
					cells[x][y] = new Rectangle(across, down, boxSize, boxSize);
					g2.drawRect(across, down, boxSize, boxSize);
				} else {
					cells[x][y] = new Rectangle(across, down, boxSize, boxSize);
					// g2.drawRect(across, down, boxSize, boxSize);
					g2.fillRect(across, down, boxSize, boxSize);
				}
				y++;
			}
			y = 0;
			x++;

		}
	}

	DisplayNotFail() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonBoard.setPreferredSize(new Dimension(this.getWidth(), 100));
		buttonBoard.setLocation(20, 100);
		Dimension button = new Dimension(100,30);
		GridLayout grid = new GridLayout(0,10);
		//buttonBoard.setLayout(grid);
		
		board.setPreferredSize(new Dimension(500, 500));

		board.addMouseListener(this);
		int borderWidth = 1;
		int boardSize = 50;
		boolean isRunning = false;
		GameOfLife life = new GameOfLife(boardSize);
		JLabel genNum = new JLabel("" + life.getGenerationNum());
		this.setPreferredSize(new Dimension(1000, 1000));
		play.setLayout(null);
		play.setSize(button);
		play.addActionListener(this);
		play.setActionCommand("play");
		nextGen.addActionListener(this);
		nextGen.setActionCommand("next");
		prevGen.addActionListener(this);
		prevGen.setActionCommand("prev");
		board.repaint();
		buttonBoard.add(board);
		// this.add(prevGen);
		// this.add(nextGen);
		buttonBoard.add(play);
		this.add(buttonBoard);
		this.pack();

	}

	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		if (command.equals("play")) {
			
			if(isRunning)	
			{
				isRunning = false;
				play.setText("Start");
			}
				
			else
			{
				isRunning = true;
				play.setText("Stop");
			}
		}
		if (command.equals("next")) {

		}
		if (command.equals("prev")) {
		}

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
		int x = (e.getX() - boardOffsetX + inset.left) / boxSize;
		int y = (e.getY() - boardOffsetY + inset.top) / boxSize;
		if (x < boardSize && x > -1 && y < boardSize && y > -1) {
			System.out.println(x + " " + y);
			if (life.getBoard().board[x][y] == 0)
				life.getBoard().board[x][y] = 1;
			else
				life.getBoard().board[x][y] = 0;
			this.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
