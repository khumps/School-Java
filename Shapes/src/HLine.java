public class HLine extends Line {

	public HLine(int length, char paintChar) {
		super(length, paintChar);
	}

	public void paintOn(int x, int y, Screen screen) {
		super.start = new Point(x, y);
		for (int i = super.start.x; i < length + x; i++) {
			if (screen.isValid(i, super.start.y))
				screen.paintAt(i, super.start.y, this);
		}

	}

	public void paintOn(Screen screen) {
		super.start = new Point(0, 0);
		paintOn(0, 0, screen);
	}

	@Override
	public void paintOn(Point point, Screen screen) {
		paintOn(point.x, point.y, screen);
	}
}
