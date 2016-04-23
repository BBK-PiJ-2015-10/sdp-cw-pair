package cwtwo;

import java.util.List;

/**
 * An interface that handles the displaying of the different feedback and outputs of the game.
 */
public interface Displayer {
	
	/**
	 * Displays the game.
	 */
	void displayGame();
	
	/**
	 * Displays the contents of a code.
	 * @param x a code.
	 */
	void displayCode(Code x);
	
	/**
	 * Displays the contents of a feedback code.
	 * @param x a code.
	 */
	void displayFeedbackCode(Code input);
	

	/**
	 * Sets the secret code for this displayer.
	 * @param secretcode . 
	 */
	void setSecretcode(Code secretcode);
	
	/**
	 * Sets the guesses to be used by this displayer.
	 * @param guesses. The guesses to be output by this displayer.
	 */
	void setGuesses(List<Code> guesses);
	
	/**
	 * The feedback to be output by this displayer.
	 * @param feedback . The feeback to be output by this displayer.
	 */
	void setFeedback(List<Code> feedback);
	
	/**
	 * Sets the visibility of the secret code.
	 * @param showcode . A boolean indicating if secret code is to be displayed or not.
	 */
	void setShowcode(Boolean showcode);

}
