package cwtwo;

import java.util.Random;

/**
 * An implementation of code generator that generates a random
 * code based on a list of available colors and peg size. 
 */
public class SecretCodeGenerator implements CodeGenerator {

    /**
     * Class default constructor. 
     */
	public SecretCodeGenerator(){

	}
	
	/**
	 * Implemenation of method from interface. It generates a random
	 * code.
	 */
	@Override
	public Code generateCode(ColorBank colorBank,
							Integer pegs) {

		Random random = new Random();

		Code secretCode = new CodeConcrete();
		
		for(int i=0;i<pegs;i++){
			secretCode.addPeg(colorBank.getColour(random.nextInt(colorBank.numColors())));
		}
		return secretCode;

	}



	
	

}
