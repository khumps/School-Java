import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RulesPane extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3642648056922948472L;
	JButton setRules = Utils.newButton(Utils.button, "Submit", "set", null);
	JTextArea aliveLabel = Utils.newArea("Number Of neighbors required for a dead cell to become alive");
	JTextField becomeAlive = new JTextField();
	JTextArea crowdedLabel = Utils.newArea("Minimum number of neighbors for overcrowding");
	JTextField overCrowded = new JTextField();
	JTextArea lonelyLabel = Utils.newArea("Number Of neighbors for an alive cell to become lonely and die");
	JTextField isLonely = new JTextField();
	JButton set = new JButton("Set");
	

	RulesPane(ActionListener listener, String command) {
		JPanel rules = new JPanel();
		
		
		rules.setLayout(new GridLayout(4,3));
		rules.add(aliveLabel);
		rules.add(becomeAlive);
		rules.add(crowdedLabel);
		rules.add(overCrowded);
		rules.add(lonelyLabel);
		rules.add(isLonely);
		rules.add(set);
		set.addActionListener(listener);
		set.setActionCommand(command);
		getContentPane().add(rules);
		setResizable(false);
		pack();
		setSize(400,160);
		
		

	}

	public int alive()
	{
		String value = becomeAlive.getText();
		if(value.isEmpty())
		return 3;
		return Integer.parseInt(value);
	}
	public int crowded()
	{
		String value = overCrowded.getText();
		if(value.isEmpty())
		return 4;
		return Integer.parseInt(value);
	}
	
	public int lonely()
	{
		String value = isLonely.getText();
		if(value.isEmpty())
		return 1;
		return Integer.parseInt(value);
	}
	
	public void resetFields()
	{
		becomeAlive.setText("");
		overCrowded.setText("");
		isLonely.setText("");
	}
		
	}
