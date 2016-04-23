package cwtwo;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class implementing a Mastermind Game.
 */
public abstract class MastermindAbstract implements Game {
	
	protected boolean showCode;
	
	protected Code secretCode;
	
	protected List<Code> guesses = new ArrayList<>();
	
	protected List<Code> feedback  = new ArrayList<>();
	
	@Inject @Turns protected Integer turns;
	
	@Inject @Pegs protected Integer pegs;
	
	@Inject protected ColorBank colorBank;
	
	protected CodeGenerator secretCodeGenerator;
	
	protected CodeComparator feedbackGenerator;
	
	protected CodeGenerator guessGenerator;
	
	protected Displayer displayer;
	
	protected boolean playAgain;
	
	protected Greeter greeter;
	
	/**
	 * Executes the game.
	 */
	abstract public void runGames();




}
