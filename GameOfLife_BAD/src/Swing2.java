import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Swing2 extends JFrame implements ActionListener {

	JLabel info = new JLabel("You haven't clicked the button yet", 10);
	private int numClicks;

	public Swing2() {
		this.setTitle("Testing");
		this.setVisible(true);
		JLabel label = new JLabel("hello");
		JPanel panel = new JPanel();
		JButton add = new JButton();
		JButton sub = new JButton();
		add.setText("Add");
		sub.setText("Subtract");
		add.setSize(100, 30);
		sub.setSize(100, 30);
		add.setLocation(20, 20);
		sub.setLocation(175, 20);
		this.add(add);
		this.add(sub);
		this.add(info);
		add.addActionListener(this);
		sub.addActionListener(this);
		add.setActionCommand("add");
		sub.setActionCommand("sub");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Swing2 test = new Swing2();
		test.setSize(300, 200);

	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("add")) {
			numClicks++;
			info.setText("You have clicked this button " + numClicks
					+ " times!");
			if (numClicks == 1)
				info.setText("You have clicked this button " + numClicks
						+ " time!");
		}
		
		if(command.equals("sub"))
		{
			numClicks--;
			
			info.setText("You have clicked this button " + numClicks + " times!");
			if(numClicks == 1)
				info.setText("You have clicked this button " + numClicks + " time!");
		}

	}

}
