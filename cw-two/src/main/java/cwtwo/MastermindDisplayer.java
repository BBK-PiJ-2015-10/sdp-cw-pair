package cwtwo;


import java.util.List;

/**
 * An implementation of the Displayer interface for a Mastermind game.
 */
public class MastermindDisplayer implements Displayer {

	protected Boolean showcode;

	protected Code secretcode;
	
	protected List<Code> guesses;
	
	protected List<Code> feedback;
	
	/**
	 * Implementation of method from interface.
	 * @See Displayer.
	 */
	@Override
	public void displayCode(Code input){
			for (int i=0;i<input.getCode().size();i++){
				System.out.print(input.getCode().get(i).getName().charAt(0));
			}
	}
	
	
	/**
	 * Implementation of method from interface.
	 * @See Displayer.
	 */
	@Override
	public void displayFeedbackCode(Code input){
		if (input.getCode().size()==0){
			System.out.print("No Pegs");
		}
		else {	
			for (int i=0;i<input.getCode().size();i++){
				System.out.print(input.getCode().get(i).getName());
				System.out.print(" ");
			}
		}
	}

	/**
	 * Implementation of method from interface.
	 * @See Displayer.
	 */
	@Override
	public void displayGame() {
		
		if (showcode) {
			System.out.print("The secret code is: ");
			displayCode(secretcode);
			System.out.println();
		}
		
		for (int i=0;i<guesses.size();i++)
		{
			displayCode(guesses.get(i));
			System.out.print(" Result: ");
			displayFeedbackCode(feedback.get(i));
			System.out.println();
		}		
	}

	/**
	 * Implementation of method from interface.
	 * @See Displayer.
	 */
	@Override
	public void setSecretcode(Code secretcode) {
		this.secretcode = secretcode;
	}

	/**
	 * Implementation of method from interface.
	 * @See Displayer.
	 */
	@Override
	public void setGuesses(List<Code> guesses) {
		this.guesses = guesses;
	}

	/**
	 * Implementation of method from interface.
	 * @See Displayer.
	 */
	@Override
	public void setFeedback(List<Code> feedback) {
		this.feedback = feedback;
	}
	
	/**
	 * Implementation of method from interface.
	 * @See Displayer.
	 */
	@Override
	public void setShowcode(Boolean showcode) {
		this.showcode = showcode;
	}
	

}
