import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
public class Display extends JFrame implements ActionListener, MouseListener{
	boolean isRunning = false;
	JMenuBar menu = new JMenuBar();
	JPanel buttonBoard = new JPanel();
	JMenuItem play = new JMenuItem("Start");
	JMenuItem nextGen = new JMenuItem("Next Generation");
	JMenuItem prevGen = new JMenuItem("Previous Generation");
	JMenuItem clear = new JMenuItem("Clear Board");
	static JTextField timerLength = new JTextField("100", 10);
	Timer timer = new Timer(Integer.parseInt(Display.timerLength.getText()), this);
	LifeBoard game = new LifeBoard();

	Display()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);;
	
	game.addMouseListener(this);
	this.add(game);
	timer.setRepeats(true);
	timer.addActionListener(this);
	timer.setActionCommand("timer");
	Dimension button = new Dimension(100,30);
	int borderWidth = 1;
	int boardSize = 50;
	boolean isRunning = false;
	GameOfLife life = new GameOfLife(boardSize);
	JLabel genNum = new JLabel("" + life.getGenerationNum());
	this.setPreferredSize(new Dimension(1000, 1000));
	//play.setLayout(null);
	play.setSize(button);
	play.addActionListener(this);
	play.setActionCommand("play");
	nextGen.addActionListener(this);
	nextGen.setActionCommand("next");
	prevGen.addActionListener(this);
	prevGen.setActionCommand("prev");
	clear.setSize(button);
	clear.addActionListener(this);
	clear.setActionCommand("clear");
	menu.add(play);
	menu.add(prevGen);
	menu.add(nextGen);
	menu.add(clear);
	this.setJMenuBar(menu);
	this.pack();
	}
	
	public static void main(String[] args)
	{
		Display test = new Display();
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
		int x = (e.getX() + LifeBoard.inset.left) / game.boxSize;
		int y = ((e.getY() + LifeBoard.inset.top) / game.boxSize);
		if (x < game.boardSize && x > -1 && y < game.boardSize && y > -1) {
			System.out.println(x + " " + y);
			if (game.life.getBoard().board[x][y] == 0)
				game.life.getBoard().board[x][y] = 1;
			else
				game.life.getBoard().board[x][y] = 0;
			this.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		if (command.equals("play")) {
			
			if(isRunning)
			{
				timer.stop();
				isRunning = false;
				play.setText("Start");
			}
				
			else
			{
				isRunning = true;
				play.setText("Stop");
				timer.start();
			}
		}
		if (command.equals("next")) {

		}
		if (command.equals("prev")) {
		}
		if(command.equals("timer"))
		{
			game.life.nextGeneration();
			
			timer.start();
		}
		if(command.equals("clear"))
			game.life.getBoard().clear();
		this.repaint();

	}
}
