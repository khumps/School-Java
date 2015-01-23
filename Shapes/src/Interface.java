import java.util.ArrayList;
import java.util.Scanner;
/*Interface that creates a Screen and allows you to draw shapes on it*/
public class Interface {
	static boolean debug = false;/*If true then prompts for shape parameters will be skipped
	and defaults will be used(see variable initializations)*/

	public static void main(String[] args) {
		/*Variables*/
		int screenWidth;
		int screenHeight;
		/*ArrayList of menuItems*/
			ArrayList<Integer> menuItems = new ArrayList<Integer>();
			menuItems.add(1);
			menuItems.add(2);
			menuItems.add(3);
			menuItems.add(4);
			menuItems.add(5);
			menuItems.add(6);
			menuItems.add(7);
		/*End ArrayList of menuItems*/
		Scanner input = new Scanner(System.in);
		int menuItem;
		int length = 5;
		int width = 5;
		int height = 5;
		int x = 0;
		int y = 0;
		char drawChar = '*';
		String text = "testing 1,2,3";
		Point start;
		boolean keepRunning = true;
		while (true) {
			System.out.println("Define the width of the screen (Drawable area): ");
			if (input.hasNextInt()) {
				screenWidth = input.nextInt();
				if (screenWidth > 0)
				{
					if(screenWidth <= 100)
					break;
					else
						System.out.println("Screen width must be less then or equal to 100");
				}
				else
					System.out.println("Invalid input. Please try again");
			} else {
				System.out.println("Invalid input. Please try again");
				input.next();
			}
		}
		while (true) {
			System.out.println("Define the height of the screen (Drawable area): ");
			if (input.hasNextInt()) {
				screenHeight = input.nextInt();
				if (screenHeight > 0)
				{
					if(screenHeight <= 100)
					
					break;
					else
						System.out.println("Screen width must be less then or equal to 100");
					}
				else
					System.out.println("Invalid input. Please try again");
			} else {
				System.out.println("Invalid input. Please try again");
				input.next();
			}
		}
		Screen screen = new Screen('+', screenWidth, screenHeight);
		do {
			System.out.println("Welcome What kind of shape would you like to draw: ");
			System.out.println("(1) Horizontal Line");
			System.out.println("(2) Vertical Line");
			System.out.println("(3) Filled Box");
			System.out.println("(4) Empty Box");
			System.out.println("(5) A Line of Text");
			System.out.println("(6) Clear the board");
			System.out.println("(7) Quit");

			if (input.hasNextInt()) {
				menuItem = input.nextInt();
				if (!menuItems.contains(menuItem)) {
					menuItem = 10;
				}
			} else {
				menuItem = 9;
			}
			// Start HLine Dialogue
			if (menuItem == 1) {
				
					System.out.println("Enter a draw character for the horizontal line: ");

					drawChar = input.next().charAt(0);
				if (!debug) {
					while (true) {
						System.out.println("Enter a length for the horizontal line: ");
						if (input.hasNextInt()) {
							length = input.nextInt();
							if (length > 0)
								if(length < 200)
								break;
							else
								System.out.println("Invalid input. Length must be less then 200");
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter starting X-Coord: ");
						if (input.hasNextInt()) {
							x = input.nextInt();
							break;
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter a starting Y-Coord: ");
						if (input.hasNextInt()) {
							y = input.nextInt();
							break;
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}
				}
				start = new Point(x, y);
				HLine line = new HLine(length, drawChar);
				line.paintOn(start, screen);
				screen.draw();
			}
			// Start VLine Dialogue
			if (menuItem == 2) {

					System.out.println("Enter a draw character for the vertical line: ");
					drawChar = input.next().charAt(0);
				if (!debug) {
					while (true) {
						System.out.println("Enter a length for the vertical line: ");
						if (input.hasNextInt()) {
							length = input.nextInt();
							if (length > 0)
								if(length < 200)
								break;
							else
								System.out.println("Invalid input. Length must be less then 200");
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter starting X-Coord: ");
						if (input.hasNextInt()) {
							x = input.nextInt();
							break;
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter a starting Y-Coord: ");
						if (input.hasNextInt()) {
							y = input.nextInt();
							break;
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}
				}
				start = new Point(x, y);
				VLine line = new VLine(length, drawChar);
				line.paintOn(start, screen);
				screen.draw();

			}
			// Start Box Dialogue
			if (menuItem == 3) {
				if (!debug) {
					System.out.println("Enter a draw character for the Filled Box: ");
					drawChar = input.next().charAt(0);
					while (true) {
						System.out.println("Enter a width for the Filled Box: ");
						if (input.hasNextInt()) {
							width = input.nextInt();
							if (width > 0)
								if(width < 200)
								break;
							else
								System.out.println("Invalid input. Width must be less then 200");
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}
					while (true) {
						System.out.println("Enter a height for the Filled Box: ");
						if (input.hasNextInt()) {
							height = input.nextInt();
							if (height > 0)
								if(height < 200)
								break;
							else
								System.out.println("Invalid input. Height must be less then 200");
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter starting X-Coord: ");
						if (input.hasNextInt()) {
							x = input.nextInt();
							break;
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter a starting Y-Coord: ");
						if (input.hasNextInt()) {
							y = input.nextInt();
							break;
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}
				}
				start = new Point(x, y);
				Box box = new Box(width, height, drawChar);
				box.paintOn(start, screen);
				screen.draw();

			}

			// Start Frame Dialogue
			if (menuItem == 4) {
				if (!debug) {
					System.out.println("Enter a draw character for the Empty Box: ");
					drawChar = input.next().charAt(0);
					while (true) {
						System.out.println("Enter a width for the Empty Box: ");
						if (input.hasNextInt()) {
							width = input.nextInt();
							if (width > 0)
								if(width < 200)
								break;
							else
								System.out.println("Invalid input. width must be less then 200");
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}
					while (true) {
						System.out.println("Enter a height for the Empty Box: ");
						if (input.hasNextInt()) {
							height = input.nextInt();
							if (height > 0)
								if(height < 200)
								break;
							else
								System.out.println("Invalid input. Height must be less then 200");
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter starting X-Coord: ");
						if (input.hasNextInt()) {
							x = input.nextInt();
							break;
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter a starting Y-Coord: ");
						if (input.hasNextInt()) {
							y = input.nextInt();
							break;
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}
				}
				start = new Point(x, y);
				Frame frame = new Frame(width, height, drawChar);
				frame.paintOn(start, screen);
				screen.draw();

			}

			// Start Text Dialogue
			if (menuItem == 5) {
				if (!debug) {
					System.out.println("Enter a String for the text Line: ");
					input.nextLine();
					text = input.nextLine();
					while (true) {
						System.out.println("Enter starting X-Coord: ");
						if (input.hasNextInt()) {
							x = input.nextInt();
							break;
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter a starting Y-Coord: ");
						if (input.hasNextInt()) {
							y = input.nextInt();
							break;
						} else {
							System.out.println("Invalid input. Please try again");
							input.next();
						}
					}
				}
				start = new Point(x, y);
				TextLine textLine = new TextLine(text);
				textLine.paintOn(start, screen);
				screen.draw();
			} else if (menuItem == 6) {
				screen.clear();
				screen.draw();
			}
			else if(menuItem == 7)
				System.exit(0);
			// Invalid input Dialogue
			else if (menuItem == 9) {
				System.out.println("I'm sorry that is not a valid answer. Please try again");
				input.next();
			} else if (menuItem == 10) {
				System.out.println("I'm sorry that is not a valid answer. Please try again");
			}

		} while (keepRunning);

		input.close();
	}
}
