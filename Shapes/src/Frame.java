/*A Frame contains a Dimension, a starting Point and a paint character*/
public class Frame extends Box{
	/*Creates a new Frame with the given width, height, and paint char*/
	public Frame(int width, int height,char paintChar) {
		super(width,height,paintChar);		
	}
	public Frame(Dimension dimension, char paintChar)
	{
		super(dimension,paintChar);
	}
	
	private boolean isBorder(int x, int y)
	{
		if(x == super.start.x || x == super.start.x + dimension.width - 1)
				return true;
		if(y == super.start.y || y == super.start.y + dimension.height - 1)
			return true;
		return false;
	}
	public void paintOn(int x, int y, Screen screen) {
		super.start = new Point(x,y);
		for (int i = x;i < x + dimension.width; i++) {
			for (int j = y; j < y + dimension.height; j++) {
				if (screen.isValid(i, j))
					if(isBorder(i,j))
					screen.paintAt(i, j, this);
			}
		}
	}

}
