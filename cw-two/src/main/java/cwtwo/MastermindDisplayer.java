package cwtwo;

import com.google.inject.Inject;

import java.util.List;



public class MastermindDisplayer implements Displayer {

	protected Boolean showcode;

	protected Code secretcode;
	
	protected List<Code> guesses;
	
	protected List<Code> feedback;
		
	public void displayCode(Code input){
			for (int i=0;i<input.getCode().size();i++){
				System.out.print(input.getCode().get(i).getName().charAt(0));
			}
	}
	
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

	@Override
	public void displayGame() {
		//Need to figure out how to leverage the showCode boolean to determine if this first display should be done or
		//not, maybe wrap it in an if statement.
		
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

	public void setSecretcode(Code secretcode) {
		this.secretcode = secretcode;
	}

	public void setGuesses(List<Code> guesses) {
		this.guesses = guesses;
	}

	public void setFeedback(List<Code> feedback) {
		this.feedback = feedback;
	}
	
	public void setShowcode(Boolean showcode) {
		this.showcode = showcode;
	}
	

}
