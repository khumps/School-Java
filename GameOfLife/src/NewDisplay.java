public class NewDisplay extends JFrame implements ActionListener, MouseListener
{

NewDisplay()
{
  int cellSize = 1;
  int boardSize = 25;
  int coords[][] = new int[boardSize][boardSize];
  GameOfLife game = new GameOfLife(boardSize);
  this.setTitle("The Game of Life");
  this.setVisible(true);
  JButton nextGen = new JButton();
	JTextField gen = new JTextField();
	JButton prevGen = new JButton();
	JButton clear = new JButton();
	JPanel board = new JPanel();
	this.setBackground(Color.WHITE);
	this.add(board);
	board.setSize(cellSize * boardSize, cellSize * boardSize);
	board.setPosition(5,10);
	board.addMousListener(this);
	}
	
	public void MouseClicked(MouseEvent e)
	{
	
	}
