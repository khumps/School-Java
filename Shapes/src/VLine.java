
public class VLine extends Line{

	public VLine(int x, int y, char paintChar) {
		super(x,y,paintChar);
		
	}
	
	public VLine(Point point, char paintChar) {
		super(point,paintChar);
		
	}

	@Override
	public void paintOn(Screen screen) {
		for(int i = 0; i <= screen.getBoard()[0].length; i++)
		{
			if(i % 2 == 0)
			{
				if(i != screen.getBoard()[0].length)
			System.out.print(screen.getBorderChar());
			}
			else
				if(i != screen.getBoard()[0].length)
			System.out.print(" ");
			if(i == screen.getBoard()[0].length)
				System.out.println(" " + screen.getBorderChar());
			
		}
		
	}

}
