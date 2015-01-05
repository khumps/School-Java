
public class Box extends Shape {
	protected Dimension dimension;

	public Box(int width, int height, char paintCharacter) {
		super(paintCharacter);
		dimension = new Dimension(width, height);
	}
	public Box(Dimension dimension, char paintCharacter) {
		super(paintCharacter);
		this.dimension = dimension;
	}

	public void paintOn(int x, int y, Screen screen) {
		for(int i = x; x > 0; i--)
		{
			for(int j = y; y < screen.getBoard().length; j++)
			{
				if(screen.isValid(i, j))
				screen.getBoard()[x][y] = this.getPaintChar();
			}
		}

	}

}
