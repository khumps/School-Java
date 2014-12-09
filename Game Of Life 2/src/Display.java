/*
 * The Display for the game of life that combines all the buttons,sliders and the board into one
*/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Hashtable;
public class Display extends JFrame implements ActionListener, MouseListener, ChangeListener{

	private static final long serialVersionUID = 6418621600276097961L;
	boolean isRunning = false;
	int sliderMin = 0;
	int sliderMax = 60;
	int sliderDefault = 30;
	int timerLength = 100;
	final int getFPS = 1000;
	final int boardOffsetX = 25;
	final int boardOffsetY = 84;
	JMenuBar menu = new JMenuBar();
	JPanel buttonBoard = new JPanel();
  	JMenuItem grid = new JMenuItem("Show Grid");
	JMenuItem play = new JMenuItem("Start");
	JMenuItem nextGen = new JMenuItem("Next Generation");
	JMenuItem clear = new JMenuItem("Clear Board");
	Timer timer = new Timer(timerLength, this);
	LifeBoard game = new LifeBoard();
	JLabel genNum = new JLabel(Integer.toString((game.life.getGenerationNum())));
	JSlider speed = new JSlider(JSlider.HORIZONTAL, sliderMin, sliderMax, sliderDefault );
	
	@SuppressWarnings("unchecked")
	Display()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);


		//Hashtable code from oracle tutorial
		/*
		@SuppressWarnings("rawtypes")
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer(sliderMax), new JLabel("Fast"));
		labelTable.put( new Integer(sliderMin), new JLabel("Stop"));
		speed.setLabelTable( labelTable );
		*/
		speed.createStandardLabels(30);
		speed.setMajorTickSpacing(30);
		speed.setMinorTickSpacing(10);
		speed.setPaintTicks(true);
		
		speed.setPaintLabels(true);
		speed.addChangeListener(this);
	game.addMouseListener(this);
	this.add(game);
	timer.setActionCommand("timer");
	Dimension button = new Dimension(100,30);
	int borderWidth = 1;
	int boardSize = 50;
	boolean isRunning = false;
	this.setPreferredSize(new Dimension(game.cellSize * game.boardSize + boardOffsetX, game.cellSize * game.boardSize + boardOffsetY));
    grid.setSize(button);
	grid.addActionListener(this);
	grid.setActionCommand("showGrid");
	play.setSize(button);
	play.addActionListener(this);
	play.setActionCommand("play");
	nextGen.addActionListener(this);
	nextGen.setActionCommand("next");
	clear.setSize(button);
	clear.addActionListener(this);
	clear.setActionCommand("clear");
	genNum.setSize(button);
	menu.add(grid);
	menu.add(play);
	menu.add(nextGen);
	menu.add(clear);
	menu.add(speed);
	menu.add(genNum);
	this.setJMenuBar(menu);
	this.pack();
	}
	public static void main(String[] args)
	{
		Display test = new Display();
		test.setVisible(true);
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent e) {
		int x = (e.getX() + LifeBoard.inset.left) / game.cellSize;
		int y = ((e.getY() + LifeBoard.inset.top) / game.cellSize);
		if (x < game.boardSize && x > -1 && y < game.boardSize && y > -1) {
			System.out.println(x + " " + y);
			if (game.life.getBoard().board[x][y] == 0)
				game.life.getBoard().board[x][y] = 1;
			else
				game.life.getBoard().board[x][y] = 0;
			this.repaint();
		}
	}

	public void mouseReleased(MouseEvent arg0) {
	}
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		if (command.equals("play")) {
			
			if(isRunning)
			{
				isRunning = false;
				play.setText("Start");
				timer.stop();
			}
				
			else
			{
				isRunning = true;
				play.setText("Stop");
				timer.start();
				System.out.println("test");
			}
		}
		if (command.equals("next")) {
			genNum.setText(Integer.toString(game.life.getGenerationNum()));
			game.life.nextGeneration();
			this.repaint();
		}
		if(command.equals("timer"))
		{
			
			game.life.nextGeneration();
			genNum.setText(Integer.toString(game.life.getGenerationNum()));
			this.repaint();
			
		}
		if(command.equals("clear"))
		{
			genNum.setText("0");
			game.life = new GameOfLife(game.boardSize);
		
		this.repaint();
		}
      		if(command.equals("showGrid"))
		{
              if(game.showGrid)
              game.showGrid = false;
              else game.showGrid = true;
		this.repaint();
		}
	}
	/* Slider Listener */
	public void stateChanged(ChangeEvent f) {
		JSlider source = (JSlider) f.getSource();
		if(speed.getValueIsAdjusting())
		{
		if(isRunning)
		{
		timerLength = getFPS / source.getValue();
		timer.setDelay(timerLength);
		timer.restart();
		}
		if(timerLength == sliderMax * 10)
			timer.stop();
		
	}
	}
}
