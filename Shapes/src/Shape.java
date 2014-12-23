
public abstract class Shape {
	private char paintChar; //What character is used to draw the shape
	protected Point start;
	
	public Shape(char paintCharacter)
	{
		this.paintChar = paintCharacter;
	}
	
	public abstract void paintOn(Screen screen);

	/**
	 * @return the paintChar
	 */
	public char getPaintChar() {
		return paintChar;
	}

	/**
	 * @param paintChar the paintChar to set
	 */
	public void setPaintChar(char paintChar) {
		this.paintChar = paintChar;
	}
}
