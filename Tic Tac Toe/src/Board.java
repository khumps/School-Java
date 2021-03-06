import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Board {
	public static enum tile{Empty,X,O};
	tile[][] board;
	int numRows;
	int numCols;
	// Creates a rectangular gameboard with dimentions rows * cols
	public Board(int rows, int cols) {
		board = new tile[rows][cols];
		numRows = rows;
		numCols = cols;
	}

	// Creates a square game board with dimentions size * size
	public Board(int size) {
		board = new tile[size][size];
		numRows = size;
		numCols = size;
	}

	public Board(tile[][] grid) {
		board = new tile[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				board[i][j] = grid[i][j];

		numRows = grid.length;
		numCols = grid[0].length;
	}

	// Returns the piece that was there
	public tile setTile(int row, int col, tile pieceValue) {
		tile oldValue = this.board[row][col];
		this.board[row][col] = pieceValue;
		return oldValue;
	}

	public tile removeTile(int row, int col) {
		tile oldValue = this.board[row][col];
		this.board[row][col] = tile.Empty;
		return oldValue;
	}

	public tile getTile(int row, int col) {
		return this.board[row][col];
	}

	public void clear() {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				board[i][j] = tile.Empty;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == tile.Empty)
					str += "   ";
				else if(board[i][j] == tile.X)
					str += " X ";
				else
					str += " O ";

			}
			str += "\n";
		}
		return str;
	}

	public boolean isValid(int row, int col) {
		if (row < board.length && row > -1)
			if (col < board[0].length && col > -1)
				return true;
		return false;
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumCols() {
		return numCols;
	}

	public Board copyBoard() {
		return new Board(this.board.length, this.board[0].length);

	}
	
	public static void main(String[] args) {
		Board game = new Board(3);
		game.setTile(1, 1, tile.X);
		
		System.out.println(game.toString());
	}
	}

