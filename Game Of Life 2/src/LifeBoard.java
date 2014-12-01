import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class LifeBoard extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5013575821528934113L;
	/**
	 * 
	 */
	/**
	 * 
	 */
	boolean isRunning = false;
	final int boxSize = 20;
	final int boardSize = 50;
	final int boardOffsetX = 200;
	final int boardOffsetY = 100;
	int x = 0;
	int y = 0;
	GameOfLife life = new GameOfLife(boardSize + 1);
	Rectangle[][] cells = new Rectangle[boardSize][boardSize];
	static Insets inset;

	public void paintComponent(Graphics g) {
		inset = getInsets();
		Graphics2D g2 = (Graphics2D) g;
		//Cycles through the board repainting it
		for (int across = 0; across <boardSize * boxSize; across += boxSize) {
			for (int down = 0; down <boardSize * boxSize; down += boxSize) {
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
		x = 0;
		y = 0;
	}
	LifeBoard() {
		this.setPreferredSize(new Dimension((boardSize * boxSize) * 2, (boardSize * boxSize) * 2));
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}
