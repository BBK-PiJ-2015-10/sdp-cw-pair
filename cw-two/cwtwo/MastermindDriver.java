package cw2;


import com.google.inject.Guice;
import com.google.inject.Injector;


public class MastermindDriver {

    // Example - change as you need to...
    public static void main(String[] args) {
        //Game g = Factory.getInstance(Game.class, true);
        //g.runGames();

        //g = Factory.getInstance(Game.class, false);
        //g.runGames();
        
    	Injector injector = Guice.createInjector(new MastermindModule());
    	
    	Game mastermind = injector.getInstance(Game.class);
    	mastermind.settings(Settings.getInstance());
    	
    	System.out.println("We are running!");
    	
    	mastermind.runGames();
    	
    
    	
    }
}