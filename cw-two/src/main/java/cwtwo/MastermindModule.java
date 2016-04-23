package cwtwo;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import cwtwo.colors.*;

import java.util.Arrays;
import java.util.List;

/**
 * A class that handles all the binding for the automatic dependency 
 * injections in the mastermind program.
 */
public class MastermindModule extends AbstractModule {

	@Override
	public void configure() {

		bind(Game.class).to(Mastermind.class);
		bind(Greeter.class).to(GreeterImpl.class);
		bind(Displayer.class).to(MastermindDisplayer.class);
		
		bind(CodeGenerator.class).annotatedWith(CodeGenerator.Secret.class).to(SecretCodeGenerator.class);
		bind(CodeComparator.class).annotatedWith(CodeGenerator.Feedback.class).to(FeedbackGenerator.class);
		bind(CodeGenerator.class).annotatedWith(CodeGenerator.Guess.class).to(GuessGenerator.class);

		// Set number of turns (or guesses) allowed per game. Change this to have a longer/shorter game.
		bind(Integer.class).annotatedWith(Turns.class).toInstance(12);

		//Set number of pegs in the secret code. Change to make game create a longer/shorter secret code.
		bind(Integer.class).annotatedWith(Pegs.class).toInstance(4);

		//All available colors in the game. Change this list to add or remove colors
		List<Colour> myList = Arrays.asList(
				Blue.getInstance(),
				Red.getInstance(),
				Yellow.getInstance(),
				Purple.getInstance(),
				Orange.getInstance(),
				Green.getInstance()
		);

		bind(new TypeLiteral<List<Colour>>(){}).
				toInstance(myList);

		//Right and Wrong Peg colors (currently: Black and White) This determines the feedback colors
		//The first is for correct color, but wrong location
		//The second color is for correct color, correct location
		bind(new TypeLiteral<Colour[]>() {}).
				toInstance(new Colour[]{
						White.getInstance(),
						Black.getInstance()
				});


		



	}

}
