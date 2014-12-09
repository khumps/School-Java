/*
 * This is the physical Board that will be painted on the screen
 */
import java.awt.Color;
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
	boolean showGrid = true;
	boolean isRunning = false;
	final int cellSize = 20; //dimensions of each cell
	final int boardSize = 25; //dimensions of board array
	int x = 0;
	int y = 0;
	Dimension pBoard = new Dimension((boardSize * cellSize) * 20, (boardSize * cellSize) * 20);//dimensions of board on screen
	GameOfLife life = new GameOfLife(boardSize + 1);
	Rectangle[][] cells = new Rectangle[boardSize][boardSize];
	static Insets inset; //used for board layout

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		super.setBackground(Color.WHITE);
		inset = getInsets();
		Graphics2D g2 = (Graphics2D) g;
		//Cycles through the board repainting it
		for (int across = 0; across <boardSize * cellSize; across += cellSize) {
			for (int down = 0; down <boardSize * cellSize; down += cellSize) {
				
				if (life.getBoard().board[x][y] == 1) {
					cells[x][y] = new Rectangle(across, down, cellSize, cellSize);
					 g2.drawRect(across, down, cellSize, cellSize);
					g2.fillRect(across, down, cellSize, cellSize);
				} else {
					if(showGrid)
					{
					cells[x][y] = new Rectangle(across, down, cellSize, cellSize);
					g2.drawRect(across, down, cellSize, cellSize);
					}
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
		setPreferredSize(pBoard);
		//setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
	}
}
