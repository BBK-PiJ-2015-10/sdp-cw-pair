package cwtwo;

import java.util.List;

public interface Displayer {
	
	public void displayGame();
	
	public void displayCode(Code x);

	public void setSecretcode(Code secretcode);
	
	public void setGuesses(List<Code> guesses);
	
	public void setFeedback(List<Code> feedback);
	
	public void setShowcode(Boolean showcode);

}
