public class Screen {
	private char[][] board;
	private char borderChar; // What character is used to draw the border

	public Screen(char borderChar, int width, int height) {
		this.setBorderChar(borderChar);
		setBoard(new char[width][height]);
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[0].length; j++)
				board[i][j] = ' ';
	}
	
	
	public void paintAt(int x, int y, Shape shape)
	{
		board[y][x] = shape.getPaintChar();
	}
	
	public boolean isValid(int x, int y) {
		if (x < board.length && x > -1)
			if (y < board[0].length && y > -1)
				return true;
		return false;
	}
	
	public void draw()
	{
		int x = 0;
		for(int i = 0; i <= getBoard()[0].length; i++)
		{
			if(i % 2 == 0)
			{
				if(i != getBoard()[0].length)
			System.out.print(getBorderChar());
			}
			else
				if(i != getBoard()[0].length)
			System.out.print(" ");
			if(i == getBoard()[0].length)
				System.out.println(" " + getBorderChar());
			
		}
		
		for(int i = 0; i < getBoard().length; i++)
		{
		for(int j = -1; j <= getBoard()[0].length; j++)
		{
			if(j == -1 || j == getBoard()[0].length)
				System.out.print(getBorderChar());
			else
				System.out.print(getBoard()[i][j]);
		}
		System.out.println("");
		}
		for(int i = 0; i <= getBoard()[0].length; i++)
		{
			if(i % 2 == 0)
			{
				if(i != getBoard()[0].length)
			System.out.print(getBorderChar());
			}
			else
				if(i != getBoard()[0].length)
			System.out.print(" ");
			if(i == getBoard()[0].length)
				System.out.println(" " + getBorderChar());
			
		}
	}


	/**
	 * @return the board
	 */
	public char[][] getBoard() {
		return board;
	}


	/**
	 * @param board the board to set
	 */
	public void setBoard(char[][] board) {
		this.board = board;
	}


	/**
	 * @return the borderChar
	 */
	public char getBorderChar() {
		return borderChar;
	}


	/**
	 * @param borderChar the borderChar to set
	 */
	public void setBorderChar(char borderChar) {
		this.borderChar = borderChar;
	}
	
	public static void main(String[] args)
	{
		Screen s = new Screen('+',30,41);
		VLine vLine = new VLine('*');
		vLine.paintOn(s);
		s.draw();
	}
}
