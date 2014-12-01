import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Dimension;
import java.awt.event.*;
import java.util.Hashtable;
public class Display extends JFrame implements ActionListener, MouseListener, ChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6418621600276097961L;
	boolean isRunning = false;
	int sliderMin = 0;
	int sliderMax = 500;
	int sliderDefault = 100;
	int timerLength = 100;
	JMenuBar menu = new JMenuBar();
	JPanel buttonBoard = new JPanel();
	JMenuItem play = new JMenuItem("Start");
	JMenuItem nextGen = new JMenuItem("Next Generation");
	JMenuItem prevGen = new JMenuItem("Previous Generation");
	JMenuItem clear = new JMenuItem("Clear Board");
	Timer timer = new Timer(timerLength, this);
	LifeBoard game = new LifeBoard();
	JLabel genNum = new JLabel(Integer.toString((game.life.getGenerationNum())));
	JSlider speed = new JSlider(JSlider.HORIZONTAL, sliderMin, sliderMax, sliderDefault );

	Display()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		speed.setMajorTickSpacing(250);
		speed.setMinorTickSpacing(125);
		speed.setPaintTicks(true);
		Hashtable labelTable = new Hashtable();
		labelTable.put( new Integer(sliderMax), new JLabel("Stop") );
		labelTable.put( new Integer(sliderMin), new JLabel("Fast") );
		speed.setLabelTable( labelTable );

		speed.setPaintLabels(true);
		speed.addChangeListener(this);
	game.addMouseListener(this);
	this.add(game);
	timer.setRepeats(true);
	timer.addActionListener(this);
	timer.setActionCommand("timer");
	Dimension button = new Dimension(100,30);
	int borderWidth = 1;
	int boardSize = 50;
	boolean isRunning = false;
	this.setPreferredSize(new Dimension(1000, 1000));
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
	genNum.setSize(button);
	menu.add(play);
	menu.add(prevGen);
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
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

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
				timer.stop();
			}
				
			else
			{
				isRunning = true;
				play.setText("Stop");
				timer.start();
			}
		}
		if (command.equals("next")) {
			genNum.setText(Integer.toString(game.life.getGenerationNum()));
			game.life.nextGeneration();
			this.repaint();
		}
		if (command.equals("prev")) {
		}
		if(command.equals("timer"))
		{
			genNum.setText(Integer.toString(game.life.getGenerationNum()));
			game.life.nextGeneration();
			this.repaint();
			
		}
		if(command.equals("clear"))
		{
			genNum.setText("0");
			game.life = new GameOfLife(game.boardSize);
		
		this.repaint();
		}
	}

	public void stateChanged(ChangeEvent f) {
		JSlider source = (JSlider) f.getSource();
		if(isRunning)
		{
		timerLength = source.getValue();
		timer.stop();
		timer.setDelay(timerLength);
		timer.start();
		}
		else
		{
			timerLength = source.getValue();
			timer.setDelay(timerLength);
		}
		
	}
}
