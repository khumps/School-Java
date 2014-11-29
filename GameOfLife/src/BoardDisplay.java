import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class BoardDisplay extends JPanel implements MouseListener, ActionListener {
	int row = 0;
	int col = 0;

	final int boxSize = 20;
	final int boardSize = 30;
	final int boardOffsetX = 200;
	final int boardOffsetY = 100;
	int x;
	int y;
	GameOfLife life = new GameOfLife(boardSize);
	Rectangle[][] cells = new Rectangle[boardSize][boardSize];
	Insets inset;
	static JTextField timerLength = new JTextField("150", 5);
	JButton timerSet = new JButton("Set");
	static Timer timer = new Timer(Integer.parseInt(timerLength.getText()), null);
	

	public void paint(Graphics g) {
		inset = getInsets();
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
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
	BoardDisplay()
	{
		timer.setActionCommand("timer");
		this.repaint();
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
		int y = ((e.getY() - boardOffsetY + inset.top) / boxSize) + 1;
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
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equals("timer")) {
			life.nextGeneration();
			this.repaint();
			timer.start();
		}
		
	}
}
