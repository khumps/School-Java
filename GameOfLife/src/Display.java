import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Display extends JFrame {

	Display() {
		final ArrayList<JButton> cells = new ArrayList<JButton>();
		int borderWidth = 1;
		final int boardSize = 50;
		final GameOfLife life = new GameOfLife(boardSize);
		this.setTitle("The Game of Life");
		this.setVisible(true);
		JButton nextGen = new JButton();
		JButton prevGen = new JButton();
		JButton clear = new JButton();
		JButton genFive = new JButton();
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
			cells.add(cell);
			cell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (life.isAlive(row, col)) {
						life.getBoard().setTile(row, col, 0);
						cell.setBackground(new JButton().getBackground());
					}

					else {
						life.getBoard().setTile(row, col, 1);
						cell.setBackground(Color.GREEN);
					}

				}

			});
		}
		game.setLocation(120, 100);
		game.setSize(750, 750);
		background.setLayout(null);
		game.setBackground(Color.green);
		JLabel genNum = new JLabel("" + life.getGenerationNum());
		prevGen.setSize(150, 30);
		prevGen.setLocation(145, 20);
		prevGen.setText("Previous Generation");
		nextGen.setSize(150, 30);
		nextGen.setLocation(300, 20);
		nextGen.setText("Next Generation");
		nextGen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				life.nextGeneration();
				for(int i = 0; i < life.getBoard().board.length; i++)
				{
					for(int j = 0; j < life.getBoard().board[0].length; j++)
					{
						if (life.isAlive(i, j)) {
							cells.get((i * boardSize) + j).setBackground(Color.GREEN);
						}

						else {
							cells.get((i * boardSize) + j).setBackground(new JButton().getBackground());
						}
					}
				}
				
			}
		});
		clear.setSize(125, 30);
		clear.setLocation(500, 20);
		clear.setText("Clear");
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent f) {
				for(int i = 0; i < cells.size(); i ++)
					cells.get(i).setBackground(new JButton().getBackground());
					life.getBoard().clear();
			}
	
		});	
		genFive.setSize(200, 30);
		genFive.setLocation(630, 20);
		genFive.setText("Plus Five Generations");
		genFive.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent g) {		
					boolean play = false;
					play = true;
					
					while(play)
					{
						life.nextGeneration();
						for(int i = 0; i < life.getBoard().board.length; i++)
						{
							for(int j = 0; j < life.getBoard().board[0].length; j++)
							{
								if (life.isAlive(i, j)) {
									cells.get((i * boardSize) + j).setBackground(Color.GREEN);
								}

								else {
									cells.get((i * boardSize) + j).setBackground(new JButton().getBackground());
								}
							}
						}
						
					}
			}
	
		});
		this.add(prevGen);
		this.add(nextGen);
		this.add(clear);
		this.add(genFive);
		this.add(genNum);
		this.add(background);
		

	}

	public static void main(String[] args) {
		Display test = new Display();
		test.setSize(1000, 1000);

	}
}