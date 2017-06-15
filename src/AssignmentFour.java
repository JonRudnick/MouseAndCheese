/* name: Jonathan Rudnick
 * date: Sep 23, 2013
 * description: Generates a board with a piece of cheese on it.
 * 				The user moves the mouse on the board until the cheese stands alone (metaphorically)
 * proposed points (out of 20): 20; all parts completed
 */

import java.util.*; //import Scanner and Random

public class AssignmentFour {

	public static void main(String[] args) {

		//initializing variables
		Random generator = new Random();
		Scanner input = new Scanner(System.in);
		int inputRows; //number of rows input by user
		int inputCols; //number of rows input by user
		int cheeseX; //cheese column location
		int cheeseY; //cheese row location
		int mouseX = 0; //mouse column location
		int mouseY = 0; //mouse row location
		String direction; //direction of mouse movement input by user

		//Ask for user column, row, and cheese location input
		System.out.println("How many columns would you like (please input an integer between 2 and 20, or 0 for random)?");
		//asks for ints above 2 so the board isn't one space
		//and below 20 so the user doesn't have to make too many moves
		inputCols = input.nextInt();
		input.nextLine(); //gobble up extra line
		if (inputCols < 2) { //catches if the user inputs an invalid number and replaces with random
			inputCols = generator.nextInt(20);
		}
		System.out.println("In which column do you want to put the cheese (please input an integer between 1 and " + inputCols + ", or above " + inputCols + " for random)?");
		cheeseX = input.nextInt();
		input.nextLine();
		if (cheeseX > inputCols) { //catches if the user inputs a number above the maximum
			cheeseX = generator.nextInt(10);
		}
		System.out.println("How many rows would you like (please input an integer between 2 and 20, or 0 for random)?");
		inputRows = input.nextInt();
		input.nextLine();
		if (inputRows < 2) {
			inputRows = generator.nextInt(20);
		}
		System.out.println("In which row do you want to put the cheese (please input an integer between 1 and " + inputRows + ", or above " + inputRows + " for random)?");
		cheeseY = input.nextInt();
		input.nextLine();
		if (cheeseY > inputRows) {
			cheeseY = generator.nextInt(10);
		}
	
		while (cheeseX == 0 && cheeseY == 0) { //catches if the cheese begins at (0,0) (whether
											   //by user input or at random) and randomizes location
			cheeseX = generator.nextInt(10);
			cheeseY = generator.nextInt(10);
		}
		for (int rows=0; rows<inputRows; rows++) {

			for (int cols=0; cols<inputCols; cols++) {
				if(cheeseX == cols && cheeseY == rows && mouseX == cheeseX && mouseY == cheeseY) {
					System.out.print('@'); //prints if mouse is on cheese
				}
				else if(cheeseX == cols && cheeseY == rows) {
					System.out.print('C'); //prints at cheese location
				}
				else if(mouseX == cols && mouseY == rows) {
					System.out.print('M'); //prints at mouse location
				}
				else {	
					System.out.print("."); //prints at blank spaces
				}
			}
			System.out.println(); //go to next row
		}
		System.out.println("Board size: " + inputRows + "x" + inputCols); //prints board size (in case board was randomly generated)
		System.out.println("Cheese location: (" + (cheeseX + 1) + "," + (cheeseY + 1) + ")"); //prints cheese location (in case cheese was randomly generated)
		System.out.println("You have " + (Math.abs(cheeseX - mouseX) + Math.abs(cheeseY - mouseY)) + " moves to go!"); //adds the absolute x and y distances to estimate number of moves left
		
		while (mouseX != cheeseX || mouseY != cheeseY) { //while the mouse is not at the cheese
			System.out.println("Move the mouse. Press (n)orth, (e)ast, (s)outh, or (w)est");
			direction = input.nextLine(); //gathers user input direction and changes the mouse
										  //location variable accordingly
			if (Character.toLowerCase(direction.charAt(0)) == 'n') {
				mouseY--;
			}
			if (Character.toLowerCase(direction.charAt(0)) == 'e') {
				mouseX++;
			}
			if (Character.toLowerCase(direction.charAt(0)) == 's') {
				mouseY++;
			}
			if (Character.toLowerCase(direction.charAt(0)) == 'w') {
				mouseX--;
			}
			for (int rows=0; rows<inputRows; rows++) { //prints board

				for (int cols=0; cols<inputCols; cols++) {
					if(cheeseX == cols && cheeseY == rows && mouseX == cheeseX && mouseY == cheeseY) {
						System.out.print('@');
					}
					else if(cheeseX == cols && cheeseY == rows) {
						System.out.print('C');
					}
					else if(mouseX == cols && mouseY == rows) {
						System.out.print('M');
					}
					else {	
						System.out.print(".");
					}
				}
				System.out.println();
			}
			System.out.println("You have " + (Math.abs(cheeseX - mouseX) + Math.abs(cheeseY - mouseY)) + " moves to go!");
		}
		System.out.println("You found the cheese!"); //prints after the while has ended
		
	}
}
