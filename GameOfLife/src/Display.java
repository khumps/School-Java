import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Display extends JFrame{

	Display()
	{
		this.setTitle("The Game of Life");
		this.setVisible(true);
		JButton nextGen = new JButton();
		JButton prevGen = new JButton();
		JPanel game = new JPanel();
		prevGen.setSize(100,30);
		prevGen.setLocation(50, 20);
		prevGen.setText("Previous Generation");
		nextGen.setSize(100,30);
		nextGen.setLocation(300, 20);
		nextGen.setText("Next Generation");
		this.add(prevGen);
		this.add(nextGen);
		this.add(game);
		
	}
	
	public static void main(String[] args)
	{
		Display test = new Display();
		test.setSize(500, 500);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}