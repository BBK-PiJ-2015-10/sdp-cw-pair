package cwtwo;

import java.util.Collections;


/**
 * An implementation of code comparator.
 */
public class FeedbackGenerator implements CodeComparator {

	private Code guesscode; 
	
	private Code secretcode;

	/**
	* Implementation of method from interface.
	* @see CodeGenerator.
	*/
    @Override
    public Code generateCode(ColorBank colorBank, Integer pegs) {
        
    	Code feedbackCode = new CodeConcrete();
    	   	
    	for (int i=0; i<pegs;i++) {


    		if ( (guesscode.getCode().get(i)) == (secretcode.getCode().get(i)) ) {

				//add a 'Correct place correct color' peg
    			feedbackCode.addPeg(colorBank.getRight());    			
    		}
    		else if ( secretcode.getCode().contains(guesscode.getCode().get(i) )) {

				//add a 'Wrong place correct color' peg
    			feedbackCode.addPeg(colorBank.getAlmost());
    		} 
    	}

		Collections.shuffle(feedbackCode.getCode());
		return feedbackCode;
    	
    }

	/**
	* Implementation of method from interface.
	* @see CodeComparator.
	*/   
	@Override
	public void useCodes(Code secretcode, Code guesscode) {
		this.secretcode=secretcode;
		this.guesscode=guesscode;
	}
}
