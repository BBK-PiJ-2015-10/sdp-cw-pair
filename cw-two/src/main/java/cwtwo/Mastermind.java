package cwtwo;

import com.google.inject.Inject;
import cwtwo.colors.Colour;

import java.util.List;
import java.util.Scanner;


/**
 * An extension of the MastermindAbstract.
 */
public class Mastermind extends MastermindAbstract  {


	@Inject
	public Mastermind(Greeter greeter,
					  @CodeGenerator.Secret CodeGenerator secret,
					  @CodeGenerator.Feedback CodeComparator feedback,
					  @CodeGenerator.Guess CodeGenerator guess,
					  Displayer displayer,
					  ColorBank colorBank){

		this.greeter = greeter;
		this.secretCodeGenerator = secret;
		this.feedbackGenerator = feedback;
		this.guessGenerator = guess;
		this.colorBank = colorBank;
		this.displayer = displayer;
		this.showCode=false;
		this.playAgain=false;
	}

	/**
	 * Implementation of method from abstract class.
	 */
	@Override
	public void runGames() {

		//Initialize
		colorBank.fillColorBank();
		greeter.settings(pegs,colorBank.getColours(),turns);
		greeter.greet();

		//Begin Game Loop
			do{
				//Set a win flag
				Boolean won = false;

				//Generate the secret Code
				this.secretCode = secretCodeGenerator.generateCode(this.colorBank, this.pegs);
				displayer.setSecretcode(this.secretCode);

				//Prompt user if they want to see the secret code
				System.out.println("Show the secret code? (Y/N) ");

				//Create scanner to read user input
				Scanner scanner = new Scanner(System.in);
				String flag;

				//Accept user input
				flag = scanner.next();

				//Set flag to determine if user has correctly made a choice
				Boolean hasSetShowCode = false;

				while (!hasSetShowCode) {

						//Show secret code
					if (flag.equals("Y")) {
						this.showCode = true;
						displayer.setShowcode(true);
						hasSetShowCode = true;
						System.out.println("The secret code is: ");
						displayer.displayCode(this.secretCode);
						System.out.println("\n");

						//Don't show secret code
					} else if (flag.equals("N")) {
						hasSetShowCode = true;
						displayer.setShowcode(false);

						//Wrong input
					} else {
						System.out.println("Whoops! Please input only Y or N!");
						flag = scanner.next();
					}
				}
				

				//Begin Gameplay, Loop through the set number of turns

				for (int i = 0; i <= turns; i++) {

					//take Player's guess. Add Player's guess to historical guesses list
					this.guesses.add(guessGenerator.generateCode(this.colorBank, this.pegs));

					//tell feedback Generator what codes to compare
					feedbackGenerator.useCodes(this.secretCode, this.guesses.get(this.guesses.size() - 1));

					//Give PLayer feedback on their guess and add feedback to list of feedbacks
					this.feedback.add(feedbackGenerator.generateCode(this.colorBank, this.pegs));

					//User guessed correctly
					if (hasWon()) {

						won = true	;


						//exit game, congratulate them
						System.out.println("YOU WON!! YAYY");
						break;
					}


					//If player guessed incorrectly, Display the current game state and prompt to guess again
					displayer.setFeedback(this.feedback);
					displayer.setGuesses(this.guesses);
					displayer.displayGame();
					System.out.println("Nope! Guess Again...");
				} //Finish Turn loop

				//Game ends and User didn't win
				if(!won){
					System.out.println("BOO You Lost! ");
				}

				//Prompt player for another game
				System.out.println("Want to play again? Y/N ? ");

				//read input
				flag = scanner.next();

				//Check for a correct User input
				boolean hasDecided = false;
				while (!hasDecided) {
					if (flag.equals("Y")) {
						this.playAgain = true;
						hasDecided = true;
						System.out.println("Let's Play!");
						this.secretCode = null;
						this.feedback.clear();
						this.guesses.clear();
						displayer.setShowcode(null);
					} else if (flag.equals("N")) {
						hasDecided = true;
						System.out.println("Thanks for Playing!");
						this.playAgain=false;
					} else {
						System.out.println("Whoops! Please input only Y or N!");
						flag = scanner.next();
					}
				}

			} while(playAgain); //Start game over if the user wanted to play again

	}


	/**
	 * Provides feedback if the player has won or not.
	 * @return a boolean with the winning outcome of the player.
	 */
	public boolean hasWon(){

		List<Colour> latestFeedback = this.feedback.get( this.feedback.size()-1 ).getCode();
		if(latestFeedback.size()!=this.pegs){
			return false;
		}

		Code winCode = new CodeConcrete();
		for(int i = 0;i<this.pegs;i++){
			winCode.addPeg(this.colorBank.getRight());
		}

		for(int j = 0;j<this.pegs;j++){

			if(latestFeedback.get(j)!=winCode.getCode().get(j)){
				return false;
			}

		}

		return true;

	}
}
