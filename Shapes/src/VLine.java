public class VLine extends Line {

	public VLine(int length, char paintChar) {
		super(length, paintChar);

	}
	@Override
	public void paintOn(int x, int y, Screen screen) {
		for (int i = super.start.y; i < length; i++) {
			if(screen.isValid(super.start.x, i))
			screen.paintAt(super.start.x, i, this);
		}

	}

	public void paintOn(Screen screen) {
		super.start = new Point(0,0);
		paintOn(0, 0, screen);
	}

	@Override
	public void paintOn(Point point, Screen screen) {
		paintOn(point.x, point.y, screen);
	}

}
