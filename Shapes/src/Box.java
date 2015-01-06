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
		for (int i = x; i < x + dimension.width; i++) {
			for (int j = y; j < y + dimension.height; j++) {
				if (screen.isValid(i, j))
					screen.paintAt(i, j, this);
			}
		}

	}

	public void paintOn(Point start, Screen screen) {
		paintOn(start.x, start.y, screen);
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void paintOn(Screen screen) {
		paintOn(0, 0, screen);
	}

}
