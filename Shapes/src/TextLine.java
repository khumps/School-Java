/*
 * A line of text that can be painted on a screen
 */

/*
 * 
 */
public class TextLine {
	private String text;
	private Point start;

	public TextLine(String text) {
		this.text = text.toString();
	}

	private boolean indexIsValid(int index) {
		if (index > -1 && index < text.length())
			return true;
		return false;
	}

	public void paintOn(int x, int y, Screen screen) {
		start = new Point(x,y);
		for (int i = 0; x <= start.x + screen.getBoard()[0].length; x++) {
				if (screen.isValid(x, start.y)) 
					if (indexIsValid(i))
					screen.paintAt(x, start.y, this.text.charAt(i));
					i++;
		}
	}

	public void paintOn(Screen screen) {
		paintOn(0, 0, screen);
	}
	
	public void paintOn(Point start, Screen screen)
	{
		paintOn(start.x,start.y,screen);
	}
}
