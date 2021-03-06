/*
 * The Display for the game of life that combines all the buttons,sliders and the board into one
 */

/* Imports */
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;

public class Display extends JFrame implements ActionListener, MouseListener, ChangeListener {

	/* Class Data */
	private static final long serialVersionUID = 6418621600276097961L;
	boolean isRunning = false;
	int sliderMin = 0;
	int sliderMax = 60;
	int sliderDefault = 30;
	final int getFPS = 1000;
	int timerLength = getFPS / 30;
	final int marginFixX = 15;
	final int marginFixY = 80;
	JMenuBar menu = new JMenuBar();
	JPanel buttonBoard = new JPanel();
	RulesPane rulesPane = new RulesPane(this, "set");
	JMenuItem rules = Utils.newMenuItem(Utils.button, "Set Rules", "rules", this, menu);
	JCheckBox grid = new JCheckBox("Show Grid");
	JMenuItem play = Utils.newMenuItem(Utils.button, "Start", "play", this, menu);
	JMenuItem nextGen = Utils.newMenuItem(new Dimension(170, 30), "Next Generation", "next", this,
			menu);
	JMenuItem awesome = Utils.newMenuItem(new Dimension(170,30), "May Cause Seizure", "awesome", this, menu);
	JMenuItem clear = Utils.newMenuItem(Utils.button, "Clear Board", "clear", this, menu);
	Timer timer = new Timer(timerLength, this);
	LifeBoard game = new LifeBoard();
	JLabel genNum = new JLabel("0");
	JSlider speed = new JSlider(JSlider.HORIZONTAL, sliderMin, sliderMax, sliderDefault);

	Display() {
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		speed.createStandardLabels(30);
		speed.setMajorTickSpacing(30);
		speed.setMinorTickSpacing(10);
		speed.setPaintTicks(true);

		speed.setPaintLabels(true);
		speed.addChangeListener(this);
		game.addMouseListener(this);
		grid.addActionListener(this);
		grid.setActionCommand("showGrid");
		grid.setSelected(true);
		add(game);
		timer.setActionCommand("timer");
		setPreferredSize(new Dimension(game.cellSize * game.boardSize + marginFixX, game.cellSize
				* game.boardSize + marginFixY));
		menu.add(grid);
		menu.add(speed);
		menu.add(genNum);
		setJMenuBar(menu);
		pack();
	}

	public static void main(String[] args) {
		Display test = new Display();
		test.setVisible(true);
	}

	/* Start Mouse Listener */
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
		int x = (e.getX() + game.inset.left) / game.cellSize;
		int y = ((e.getY() + game.inset.top) / game.cellSize);
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

	/* End Mouse Listener */

	/* Button Listener */
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		if (command.equals("play")) {

			if (isRunning) {
				isRunning = false;
				play.setText("Start");
				timer.stop();
			}

			else {
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
		if (command.equals("timer")) {

			game.life.nextGeneration();
			genNum.setText(Integer.toString(game.life.getGenerationNum()));
			this.repaint();

		}
		if (command.equals("clear")) {
			timer.stop();
			isRunning = false;
			play.setText("Start");
			genNum.setText("0");
			game.life.getBoard().clear();
			;

			this.repaint();
		}
		if (command.equals("showGrid")) {
			if (game.showGrid)
				game.showGrid = false;
			else
				game.showGrid = true;
			this.repaint();
		}
		if (command.equals("rules")) {
			rulesPane.setLocationRelativeTo(this);
			rulesPane.setLocation(this.getWidth(), (int) Component.CENTER_ALIGNMENT);
			rulesPane.setVisible(true);
		}
		if (command.equals("set")) {
			game.life.isLonely = rulesPane.lonely();
			game.life.isOverCrowded = rulesPane.crowded();
			game.life.willBecomeAlive = rulesPane.alive();
		}
		if (command.equals("awesome")) {
			/* Cool config I found */

			play.setText("Stop");
			game.life.getBoard().clear();
			rulesPane.resetFields();
			game.life.isLonely = rulesPane.lonely();
			game.life.isOverCrowded = rulesPane.crowded();
			game.life.willBecomeAlive = 0;
			timer.start();
			isRunning = true;
		}
	}

	/* Slider Listener */
	public void stateChanged(ChangeEvent f) {
		JSlider source = (JSlider) f.getSource();
			if (isRunning) {
				if (source.getValue() == 0)
					timer.stop();
				else {
					timerLength = getFPS / source.getValue();
					timer.setDelay(timerLength);
					timer.restart();
				}
			}
			
			
	}
}
