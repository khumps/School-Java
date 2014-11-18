import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Display extends JFrame {

	Display() {
		final ArrayList<JButton> cells = new ArrayList<JButton>();
		int borderWidth = 1;
		final int boardSize = 25;
		final GameOfLife life = new GameOfLife(boardSize);
		this.setTitle("The Game of Life");
		this.setVisible(true);
		JButton nextGen = new JButton();
		JButton prevGen = new JButton();
		JPanel background = new JPanel();
		background.setBackground(Color.BLACK);
		JPanel game = new JPanel();
		background.add(game);
		GridLayout grid = new GridLayout(boardSize, boardSize, 0, 0);
		game.setLayout(grid);
		for (int i = 0; i < boardSize * boardSize; i++) {
			final int row = (i / boardSize) - 1;
			final int col = i % boardSize;
			final JButton cell = new JButton();
			cell.setBorder(BorderFactory.createMatteBorder(borderWidth, 0,
					borderWidth, borderWidth, Color.BLACK));
			game.add(cell);
			cell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (life.isAlive(row, col)) {
						life.board.setTile(row, col, 0);
						cell.setBackground(new JButton().getBackground());
						cells.add(cell);
					}

					else {
						life.board.setTile(row, col, 1);
						cell.setBackground(Color.GREEN);
						cells.add(cell);
					}

				}

			});
		}
		game.setLocation(120, 100);
		game.setSize(750, 750);
		background.setLayout(null);
		game.setBackground(Color.green);
		prevGen.setSize(150, 30);
		prevGen.setLocation(545, 20);
		prevGen.setText("Previous Generation");
		nextGen.setSize(150, 30);
		nextGen.setLocation(700, 20);
		nextGen.setText("Next Generation");
		nextGen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				life.nextGeneration();
				for(int i = 0; i < life.board.board.length; i++)
				{
					for(int j = 0; j < life.board.board[0].length; j++)
					{
						if (life.isAlive(i, j)) {
							cells.get((i * boardSize) + j).setBackground(new JButton().getBackground());
						}

						else {
							cells.get((i * boardSize) + j).setBackground(Color.GREEN);
						}
					}
				}
				
			}
		});
		this.add(prevGen);
		this.add(nextGen);
		this.add(background);

	}

	public static void main(String[] args) {
		Display test = new Display();
		test.setSize(1000, 1000);

	}
}