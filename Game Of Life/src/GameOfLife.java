import java.util.ArrayList;
import java.util.Random;

public class GameOfLife {

	private ArrayList<Board> boards = new ArrayList<Board>();
	private Board board;
	private Board modifiedBoard;
	int willBecomeAlive = 3;
	int isOverCrowded = 4;
	int isLonely = 1;
	private int generationNum = 0;

	public Board getBoard(int i) {
		return board;
	}

	public Board getBoard() {
		return board;
	}

	public Board getModifiedBoard() {
		return modifiedBoard;
	}

	public GameOfLife(int rows, int cols) {
		board = new Board(rows, cols);
		for (int i = 0; i < this.board.board.length; i++) {
			for (int j = 0; j < this.board.board[0].length; j++) {
				board.board[i][j] = 0;
			}
		}
	}

	public GameOfLife(int size) {
		board = new Board(size);
	}

	public GameOfLife(int[][] grid) {
		board = new Board(grid);
	}

	public int getGenerationNum() {
		return generationNum;
	}

	public boolean isAlive(int row, int col) {
		if (board.isValid(row, col))
			if (board.board[row][col] == 1) {
				return true;
			}
		return false;
	}

	public int countNeighbors(int row, int col) {
		int numNeighbors = 0;
		if (this.isAlive(row, col))
			numNeighbors--;
		for (int i = row - 1; i < row + 2; i++) {
			for (int j = col - 1; j < col + 2; j++) {
				if (this.isAlive(i, j)) {
					numNeighbors++;
				}
			}
		}
		return numNeighbors;
	}

	private boolean willLive(int row, int col) {
		if (this.isAlive(row, col)) {
			if (this.countNeighbors(row, col) <= isLonely || this.countNeighbors(row, col) >= isOverCrowded) {
				return false;
			}
			return true;
		}
		if (this.countNeighbors(row, col) == willBecomeAlive) {
			return true;
		}
		return false;
	}

	public String toString() {
		return board.toString();
	}

	public int getCell(int row, int col) {
		return board.board[row][col];
	}

	public void nextGeneration() {
		boards.add(board);
		modifiedBoard = this.board.copyBoard();
		for (int i = 0; i < this.board.board.length; i++) {
			for (int j = 0; j < this.board.board[0].length; j++) {
				if (this.willLive(i, j) == true)
					this.modifiedBoard.board[i][j] = 1;
				if (this.willLive(i, j) == false)
					this.modifiedBoard.board[i][j] = 0;
			}
		}
		this.board = new Board(modifiedBoard.board);
		boards.add(board);
		generationNum++;
	}
	/* Generates a random game of life board (Fills it randomly with dead or alive cells)*/
	public void randomGame()
	{
		Random rand = new Random();
		for(int i = 0; i < this.board.board.length; i++)
			for(int j = 0; j < this.board.board[0].length; j++)
			{
				if(rand.nextBoolean())
				{
					this.setCell(i, j, 1);
				System.out.println("true");
				}
				else
				{
					System.out.println("false");
					this.setCell(i, j, 0);
				}
			}
	}
	/* Set cells in the game board */
	public int setCell(int row, int col, int pieceValue)
	{
		int oldValue = this.board.board[row][col];
		this.board.board[row][col] = pieceValue;
		return oldValue;
	}
	/* Set cells in the modified game board */
	public int setMCell(int row, int col, int pieceValue)
	{
		int oldValue = this.modifiedBoard.board[row][col];
		this.modifiedBoard.board[row][col] = pieceValue;
		return oldValue;
	}

	public static String toString(int[][] board) {
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

	public static void main(String[] args) {
		GameOfLife game = new GameOfLife(3);
		game.setCell(0,1,1);
		game.setCell(1,1,1);
		game.setCell(2,1,1);
		game.setCell(1,0,1);
		game.setCell(1,2,1);
		System.out.println(game.toString());
		System.out.println("isAlive() for (1,1) returns: " + game.isAlive(1, 1));
		System.out.println("countNeighbors() for (1,1) returns: " + game.countNeighbors(1, 1));
		System.out.println("willLive() for (1,1) returns: " + game.willLive(1, 1));
		System.out.println("isAlive for (0,0) returns: " + game.isAlive(0, 0));
		System.out.println("countNeighbors() for (0,0) returns: " + game.countNeighbors(0, 0));
		System.out.println("willLive() for (0,0) returns: " + game.willLive(0, 0));
		System.out.println("isAlive for (0,2) returns: " + game.isAlive(0, 2));
		System.out.println("countNeighbors() for (0,2) returns: " + game.countNeighbors(0, 2));
		System.out.println("willLive() for (0,2) returns: " + game.willLive(0, 2));
		System.out.println("isAlive for (2,0) returns: " + game.isAlive(2, 0));
		System.out.println("countNeighbors() for (2,0) returns: " + game.countNeighbors(2, 0));
		System.out.println("willLive() for (2,0) returns: " + game.willLive(2, 0));
		System.out.println("isAlive for (2,2) returns: " + game.isAlive(2, 2));
		System.out.println("countNeighbors() for (2,2) returns: " + game.countNeighbors(2, 2));
		System.out.println("willLive() for (2,2) returns: " + game.willLive(2, 2));

	}

}
