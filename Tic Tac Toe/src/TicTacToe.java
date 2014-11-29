public class TicTacToe {
	Board board = new Board(3);
	
	public TicTacToe()
	{		
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.board.setTile(1, 1, Board.tile.X);
		
		System.out.println(game.board.toString());
	}
}
