/*
 * Abstract line
 * Contains a length and a paint character
 */
public abstract class Line extends Shape {
	protected int length;// Length of the line

	/* Creates a new line with given length and paint character */
	public Line(int length, char paintChar) {
		super(paintChar);
		this.length = length;
	}

	/* Paints the line on the screen at the given x and y coord */
	public abstract void paintOn(int x, int y, Screen screen);

	/* Paints the line on the screen at the given Point */
	public abstract void paintOn(Point point, Screen screen);

}
