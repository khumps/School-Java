public abstract class Polygon {
	private double orientation = 0; //Current rotation of the Polygon
	private final PolarCoord center;
	private final PolarCoord[] endPoints;
	public Polygon(PolarCoord center, PolarCoord... coords) {
		this.center = center;
		this.endPoints = coords;
	}
	
	public abstract void rotate(double degrees);

}
