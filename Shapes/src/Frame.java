/*A Frame contains a Dimension, a starting Point and a paint character*/
public class Frame extends Box{
	
	/*Creates a new Frame with the given width, height, and paint character*/
	public Frame(int width, int height,char paintChar) {
		super(width,height,paintChar);		
	}
	
	/*Creates a new Frame with the given Dimension, and paint character*/
	public Frame(Dimension dimension, char paintChar)
	{
		super(dimension,paintChar);
	}
	
	/*Checks if the given coordd are on the border of the box*/
	private boolean isBorder(int x, int y)
	{
		if(x == super.start.x || x == super.start.x + dimension.width - 1)
				return true;
		if(y == super.start.y || y == super.start.y + dimension.height - 1)
			return true;
		return false;
	}
	
	/*Checks if the given Point is on the border of the box*/
	private boolean isBorder(Point point)
	{
		return isBorder(point.x,point.y);
	}
	/*Paints the Frame starting at the given coords on the screen*/
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
	
	/*Paints the Frame starting at the given Point on the screen*/
	public void paintOn(Point start, Screen screen)
	{
		paintOn(start.x,start.y,screen);
	}
	
	/*Paints the frame at default coords(0,0) on the screen*/
	public void paintOn(Screen screen)
	{
		paintOn(0,0,screen);
	}
}
