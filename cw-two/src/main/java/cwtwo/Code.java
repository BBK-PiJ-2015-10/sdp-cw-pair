
package cwtwo;
import cwtwo.colors.Colour;

import java.util.List;

/**
 * An interface that provides a code and allows to add the elements of the code
 */
public interface Code {

	/**
	 * @return a List of colours that forms the code.
	 */
	List<Colour> getCode();
	
	/**
	 * Allows to add a series of colours to a code.
	 * @param peg . A colour to be added to the code.
	 */
	void addPeg(Colour peg);
	
}
