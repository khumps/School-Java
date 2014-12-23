public class VLine extends Line {

	public VLine(char paintChar) {
		super(paintChar);

	}

	@Override
	public void paintOn(int x, int y, int length, Screen screen) {
		for (int i = super.start.y; i < length; i++) {
			if(screen.isValid(super.start.x, i))
			screen.paintAt(super.start.x, i, this);
		}

	}

	public void paintOn(Screen screen) {
		super.start = new Point(0,0);
		paintOn(0, 0, 5, screen);
	}

	@Override
	public void paintOn(Point point, int length, Screen screen) {
		paintOn(point.x, point.y, length, screen);
	}

}
