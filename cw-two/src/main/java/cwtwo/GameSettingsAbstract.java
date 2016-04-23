package cwtwo;
import java.awt.*;
import java.util.List;

/**
 * An abstract class with the different settings of the game.
 */
public abstract class GameSettingsAbstract {
	
	List<Color> colours;
	
	List<Color> pegColours;
	
	int numPegs;
	
	int numTurns;
	
	/**
	 * Provides the list of colors available in this game. 
	 * @return list of colors. The list of colors associated with this game.
	 */
	public List<Color> getColours(){
		return this.colours;
	}
	
	/**
	 * Provides the list of peg colors available in this game. 
	 * @return list of peg colors. The list of peg colors associated with this game.
	 */
	public List<Color> getpegColours(){
		return this.pegColours;
	}
	
	/**
	 * Provides the number of pegs associated with this game.
	 * @return number of pegs.
	 */
	public int getNumPegs(){
		return this.numPegs;
	}
	
	/**
	 * Provides the number of turns associated with this game.
	 * @return number of turns.
	 */
	public int getNumTurns(){
		return this.numTurns;
	}

	
}
