
public class Utils{
	public static JButton makeButton(Dimension size, String text, String command,ActionListener listener)
	{
		JButton button = new JButton(text);
		button.addActionListener(listener);
		button.addActionCommand(command);
		button.setPreferredSize(size);
		return button;
	}
}