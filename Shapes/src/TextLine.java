public class TextLine {
	final String text;

	public TextLine(String text) {
		this.text = text.toString();
	}

	private boolean indexIsValid(int index) {
		if (index > -1 && index < text.length())
			return true;
		return false;
	}

	public void paintOn(int x, int y, Screen screen) {
		int i = 0;
		for (int j = x; j < x + screen.getBoard()[0].length; j++) {
			if (indexIsValid(i))
				if (screen.isValid(j, y)) {
					screen.paintAt(j, y, this.text.charAt(i));
					i++;
				}
		}
	}

	public void paintOn(Screen screen) {
		paintOn(0, 0, screen);
	}
}
