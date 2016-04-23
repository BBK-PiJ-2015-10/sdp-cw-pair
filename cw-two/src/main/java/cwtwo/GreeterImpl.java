package cwtwo;

import cwtwo.colors.Colour;

import java.util.List;

/**
 * A print screen implementation of the Greeter interface.
 */
public class GreeterImpl implements Greeter {

	
	private String greeting;
	
	/**
	 * Implementation of method based on interface.
	 * @see Greeter. 
	 */
	@Override
	public void settings(int numPegs, List<Colour> colors, int turns){

		String colorNames = "";
		for(Colour color : colors){
			colorNames += color.getName()+", ";
		}
		colorNames=colorNames.substring(0,colorNames.length()-2);
	
	this.greeting = "Welcome to Mastermind. \nThis is a text version of the classic board game Mastermind. Here are some Rules:\n"
			+ "- The computer will think of a secret code. \n- The code consists of " + numPegs + " colored pegs. "
					+ "\n- The pegs may be one of six colors: " + colorNames.toString() + "."
					+ "\n- A color may appear more than once in the code."
					+ "\n- You try to guess what colored pegs are in the code and what order they are in."
					+ "\n- After making a guess the result will be displayed.\n"
					+ "- A result consists of a black peg for each peg you have exactly correct (color and position) in your guess."
					+ "\n- For each peg in the guess that is the correct color, but is out of position, you get a white peg."
					+ "\n- Only the first letter of the color is displayed. B for Blue, R for Red, and so forth."
					+ "\n- When entering guesses you only need to enter the first character of the color as a capital letter."
					+ "\n"
					+ "\nYou have " + turns + " turns to guess the answer or you lose the game. Good Luck!";
	}
	
	/**
	 * Implementation of method based on interface.
	 * @see Greeter. 
	 */
	@Override
	public void greet() {
		System.out.println(greeting);
	}

}
