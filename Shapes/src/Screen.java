public class Screen {
	private char[][] board;
	private char borderChar; // What character is used to draw the border

	public Screen(char borderChar, int width, int height) {
		this.borderChar = borderChar;
		board = new char[width][height];
	}
	
	
	public void paintAt(int x, int y)
	{
		//board[x][y] = Shape.getPaintChar();
	}
	
	public void draw()
	{
		int x = 0;
		for(int i = 0; i <= board[0].length; i++)
		{
			if(i % 2 == 0)
			{
				if(i != board[0].length)
			System.out.print(borderChar);
			}
			else
				if(i != board[0].length)
			System.out.print(" ");
			if(i == board[0].length)
				System.out.println(" " + borderChar);
			
		}
		
		for(int i = 0; i < board.length; i++)
		{
		for(int j = -1; j <= board[0].length; j++)
		{
			if(j == -1 || j == board[0].length)
				System.out.print(borderChar);
			else
				System.out.print(board[i][j]);
		}
		System.out.println("");
		}
		for(int i = 0; i <= board[0].length; i++)
		{
			if(i % 2 == 0)
			{
				if(i != board[0].length)
			System.out.print(borderChar);
			}
			else
				if(i != board[0].length)
			System.out.print(" ");
			if(i == board[0].length)
				System.out.println(" " + borderChar);
			
		}
	}
	
	public static void main(String[] args)
	{
		Screen s = new Screen('*',30,41);
		s.draw();
	}
}
