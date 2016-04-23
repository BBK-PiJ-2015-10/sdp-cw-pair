
package cwtwo;

import cwtwo.colors.Colour;

import java.util.List;

/**
 * An interface that facilitates the setting of the game and the greeting.
 */
public interface Greeter {

	/**
	 * Facilitates the set up of the settings in the game.
	 * @param numPegs . The max number of pegs in each code.
	 * @param colors . The list of colors to be used in the game.
	 * @param turns . The max number of turns per game.
	 */
	void settings(int numPegs, List<Colour> colors, int turns);
	
	/**
	 * Sets up the greeting associated with this game.
	 */
	void greet();
	
}
