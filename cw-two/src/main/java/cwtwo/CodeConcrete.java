package cwtwo;

import cwtwo.colors.Colour;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the code interface.
 * Leverages an List to keep track of the colors that form this code.
 */
public class CodeConcrete implements Code {
	
	private List<Colour> code = new ArrayList<>();
	
	
	/**
	 * Implementation of method from interface.
	 * @see Code.
	 */
    @Override
	public void addPeg(Colour peg){
		this.code.add(peg);
	}

    /**
     * Implementation of method from interface.
	 * @see Code.
     */
	@Override
	public List<Colour> getCode() {
		return this.code;
	}


}
