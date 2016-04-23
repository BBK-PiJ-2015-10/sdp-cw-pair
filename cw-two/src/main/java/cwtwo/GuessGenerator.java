package cwtwo;

import java.util.Scanner;

/**
 * An implementation of code generator that generates a code based on an input guess
 * from the player of the game.
 */
public class GuessGenerator implements  CodeGenerator {

	/**
	 * Provides a feedback if an input string is associated with a colorbank or not.
	 * @param input . An input string.
	 * @param colorBank . A colorbank of colors.
	 * @return a boolean confirming if the string is associated with any colors.
	 */
	public Boolean hasValidColors(String input, ColorBank colorBank){
		for (int i=0; i< input.length();i++){
			if ( colorBank.getColourByKey(input.charAt(i)) == null) {
				return false;
			}
		}
		return true;
	}
	

	/**
	 * Implementation of method from interface based on an input guess
	 * from the player.
	 */
    @Override
    public Code generateCode(ColorBank colorBank,Integer pegs) {
        
    	Scanner scanner = new Scanner(System.in);
    	String input;
    	
    	
    	System.out.println("Please enter a guess: ");
    	input = scanner.next();
    
    	while ( input.length() != pegs || !hasValidColors(input,colorBank) ) {
    		if ( input.length() != pegs){
    			System.out.println("Please make your guess " +pegs +" pegs long." );
    		}
    		if ( !hasValidColors(input,colorBank) ){
    			System.out.println("Please only use valid colors.");
    		}
    		
    		System.out.println("Please enter a guess: ");
        	input = scanner.next();
    	}
    	
    	Code guessCode = new CodeConcrete();
    
    	for(int i=0;i<pegs;i++){
			guessCode.addPeg(colorBank.getColourByKey(input.charAt(i)));
		}
    	return guessCode;
    	
    }
}
