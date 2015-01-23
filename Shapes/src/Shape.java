/*
 * An abstract class for a shape object
 * Has a paint character and a starting point
 */
public abstract class Shape {
	private char paintChar; /* What character is used to draw the shape */
	protected Point start; /* Starting point of the shape */

	/* Creates a new Shape for a subclass object */
	public Shape(char paintCharacter) {
		this.paintChar = paintCharacter;
	}

	/* Paints the shape on given screen */
	public abstract void paintOn(Screen screen);

	/**
	 * @return the paintChar
	 */
	public char getPaintChar() {
		return paintChar;
	}

	/**
	 * @param paintChar
	 *            the paintChar to set
	 */
	public void setPaintChar(char paintChar) {
		this.paintChar = paintChar;
	}
}
