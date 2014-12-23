
public abstract class Line extends Shape {
	protected Point start;
	protected int length;

	public Line(char paintChar) {
		super(paintChar);		
	}
	public abstract void paintOn(Screen screen);
	public abstract void paintOn(int x, int y, int length, Screen screen);
	public abstract void paintOn(Point point, int length, Screen screen);



}
