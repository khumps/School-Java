import java.util.Scanner;

public class Interface {
	static boolean debug = false;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Screen screen = new Screen('+', 51, 20);
		int menuItem;
		int length = 5;
		int width = 5;
		int height = 5;
		int x = 5;
		int y = 5;
		char drawChar = '*';
		String text = "testing 1,2,3";
		Point start;
		boolean keepRunning = true;
		do {
			System.out.println("Welcome What kind of shape would you like to draw: ");
			System.out.println("(1) Horizontal Line");
			System.out.println("(2) Vertical Line");
			System.out.println("(3) Filled Box");
			System.out.println("(4) Empty Box");
			System.out.println("(5) A Line of Text");
			System.out.println("(6) Clear the board");

			if (input.hasNextInt()) {
				menuItem = input.nextInt();
			} else {
				menuItem = 9;
			}
			// Start HLine Dialogue
			if (menuItem == 1) {
				if (!debug) {
					System.out.println("Enter a draw character for the horizontal line: ");

					drawChar = input.next().charAt(0);

					while (true) {
						System.out.println("Enter a length for the horizontal line: ");
						if (input.hasNextInt()) {
							length = input.nextInt();
							if (length > 0)

								break;
							else
								System.out.println("invalid input. Please try again");
						} else {
							System.out.println("invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter starting X-Coord: ");
						if (input.hasNextInt()) {
							x = input.nextInt();
							break;
						} else {
							System.out.println("invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter a starting Y-Coord: ");
						if (input.hasNextInt()) {
							y = input.nextInt();
							break;
						} else {
							System.out.println("invalid input. Please try again");
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
				if (!debug) {
					System.out.println("Enter a draw character for the vertical line: ");
					drawChar = input.next().charAt(0);
					while (true) {
						System.out.println("Enter a length for the vertical line: ");
						if (input.hasNextInt()) {
							length = input.nextInt();
							if (length > 0)

								break;
							else
								System.out.println("invalid input. Please try again");
						} else {
							System.out.println("invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter starting X-Coord: ");
						if (input.hasNextInt()) {
							x = input.nextInt();
							break;
						} else {
							System.out.println("invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter a starting Y-Coord: ");
						if (input.hasNextInt()) {
							y = input.nextInt();
							break;
						} else {
							System.out.println("invalid input. Please try again");
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
									break;
							else
								System.out.println("invalid input. Please try again");
						} else {
							System.out.println("invalid input. Please try again");
							input.next();
						}
					}
					while (true) {
						System.out.println("Enter a height for the Filled Box: ");
						if (input.hasNextInt()) {
							height = input.nextInt();
								if (height > 0)
									break;
							else
								System.out.println("invalid input. Please try again");
						} else {
							System.out.println("invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter starting X-Coord: ");
						if (input.hasNextInt()) {
							x = input.nextInt();
							break;
						} else {
							System.out.println("invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter a starting Y-Coord: ");
						if (input.hasNextInt()) {
							y = input.nextInt();
							break;
						} else {
							System.out.println("invalid input. Please try again");
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
									break;
						 else
								System.out.println("invalid input. Please try again");
						} else {
							System.out.println("invalid input. Please try again");
							input.next();
						}
					}
					while (true) {
						System.out.println("Enter a height for the Empty Box: ");
						if (input.hasNextInt()) {
							height = input.nextInt();
								if (height > 0)
									break;
							 else
								System.out.println("invalid input. Please try again");
						} else {
							System.out.println("invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter starting X-Coord: ");
						if (input.hasNextInt()) {
							x = input.nextInt();
							break;
						} else {
							System.out.println("invalid input. Please try again");
							input.next();
						}
					}

					while (true) {
						System.out.println("Enter a starting Y-Coord: ");
						if (input.hasNextInt()) {
							y = input.nextInt();
							break;
						} else {
							System.out.println("invalid input. Please try again");
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
								text = input.nextLine();
								text = input.nextLine();
								System.out.println("test");
								while (true) {
									System.out.println("Enter starting X-Coord: ");
									if (input.hasNextInt()) {
										x = input.nextInt();
										break;
									} else {
										System.out.println("invalid input. Please try again");
										input.next();
									}
								}

								while (true) {
									System.out.println("Enter a starting Y-Coord: ");
									if (input.hasNextInt()) {
										y = input.nextInt();
										break;
									} else {
										System.out.println("invalid input. Please try again");
										input.next();
									}
								}
							}
							start = new Point(x, y);
							TextLine textLine = new TextLine(text);
							textLine.paintOn(start, screen);
							screen.draw();
						}
			else if(menuItem == 6)
			{
				screen.clear();
				screen.draw();
			}
			// Invalid Input Dialogue
			else if (menuItem == 9) {
				System.out.println("I'm sorry that is not a valid answer. Please try again");
				input.next();
			}

		} while (keepRunning);

	}

}
