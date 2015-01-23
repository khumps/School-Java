/*A line of text that can be painted on a screen*/

public class TextLine {
	private String text;
	private Point start;

	/* Constructs a new TextLine with the given text */
	public TextLine(String text) {
		this.text = text.toString();
	}

	/* Checks if the index is a valid index in the TextLine */
	private boolean indexIsValid(int index) {
		if (index > -1 && index < text.length())
			return true;
		return false;
	}

	/* Paints the TextLine on the Screen at x,y */
	public void paintOn(int x, int y, Screen screen) {
		start = new Point(x, y);
		for (int i = 0; x <= start.x + screen.getBoard()[0].length; x++) {
			if (screen.isValid(x, start.y))
				if (indexIsValid(i))
					screen.paintAt(x, start.y, this.text.charAt(i));
			i++;
		}
	}

	/* Paints the TextLine on the Screen at 0,0 */
	public void paintOn(Screen screen) {
		paintOn(0, 0, screen);
	}

	/* Paints the TextLine on the Screen at the given Point */
	public void paintOn(Point start, Screen screen) {
		paintOn(start.x, start.y, screen);
	}

	public static void main(String[] args) {
		Screen screen = new Screen('+', 20, 10);
		TextLine textLine = new TextLine("testing 1,2,3");
		textLine.paintOn(3, 3, screen);
		screen.draw();
	}
}
