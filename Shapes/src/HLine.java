
public class HLine extends Line {

	public HLine(char paintChar) {
		super(paintChar);
		
	}
	
	public HLine(char paintChar) {
		super(paintChar);

}

	public void paintOn(Screen screen) {
		for(int i = super.start.getX();i < start.getX() + length; i++)
		{
			screen.paintAt(i, super.start.getX(), this);
		}
		
	}
}
