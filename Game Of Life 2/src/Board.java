public class Board {
	int[][] board;
	int numRows;
	int numCols;
	// Creates a rectangular gameboard with dimentions rows * cols
	public Board(int rows, int cols) {
		board = new int[rows][cols];
		numRows = rows;
		numCols = cols;
	}

	// Creates a square game board with dimentions size * size
	public Board(int size) {
		board = new int[size][size];
		numRows = size;
		numCols = size;
	}
	// Creates a rectangular board from a 2D int array
	public Board(int[][] grid) {
		board = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				board[i][j] = grid[i][j];

		numRows = grid.length;
		numCols = grid[0].length;
	}

	// Returns the piece that was at the given coordinates
	// Returns the old value of the tile
	public int setTile(int row, int col, int pieceValue) {
		int oldValue = this.board[row][col];
		this.board[row][col] = pieceValue;
		return oldValue;
	}
	// Removes the tile at the given coordinates
	// Returns the old value of the tile
	public int removeTile(int row, int col) {
		int oldValue = this.board[row][col];
		this.board[row][col] = 0;
		return oldValue;
	}
	// Returns the value of the tile at the given coordinates
	public int getTile(int row, int col) {
		return this.board[row][col];
	}
	// Clears the board
	public void clear() {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				board[i][j] = 0;
	}
	// Prints the board as a String in the console
	public String toString() {
		String str = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0)
					str += " - ";
				else
					str += " * ";

			}
			str += "\n";
		}
		return str;
	}
	// Checks if the given coordinates are on the board
	public boolean isValid(int row, int col) {
		if (row < board.length && row > -1)
			if (col < board[0].length && col > -1)
				return true;
		return false;
	}
	// Returns the number of rows in the board
	public int getNumRows() {
		return numRows;
	}
	// Returns the number of columns in the board
	public int getNumCols() {
		return numCols;
	}
	// Returns a copy of the board
	public Board copyBoard() {
		return new Board(this.board.length, this.board[0].length);

	}

}
