package cwtwo;

/**
 * Created by elianne on 21/02/2016.
 */

import java.util.Collections;

public class FeedbackGenerator implements CodeComparator {

	private Code guesscode; 
	
	private Code secretcode;

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

	@Override
	public void useCodes(Code secretcode, Code guesscode) {
		this.secretcode=secretcode;
		this.guesscode=guesscode;
	}
}
