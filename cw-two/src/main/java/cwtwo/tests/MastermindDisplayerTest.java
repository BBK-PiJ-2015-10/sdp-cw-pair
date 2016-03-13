package cwtwo.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import cwtwo.MastermindDisplayer;
import cwtwo.Displayer;
import cwtwo.Code;
import cwtwo.CodeConcrete;
import cwtwo.colors.Black;
import cwtwo.colors.Blue;
import cwtwo.colors.Colour;
import cwtwo.colors.Green;
import cwtwo.colors.Orange;
import cwtwo.colors.Purple;
import cwtwo.colors.Red;
import cwtwo.colors.White;
import cwtwo.colors.Yellow;

import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;




public class MastermindDisplayerTest {
	
	private Boolean showcode;

	private Code secretcode = new CodeConcrete();
	
	private List<Code> guesses = new ArrayList<>();
	
	private List<Code> feedback = new ArrayList<>();
	
	private Displayer displayer = new MastermindDisplayer();
	
	private Code guess1 = new CodeConcrete();
	
	private Code guess2 = new CodeConcrete();
	
	private Code feedback1 = new CodeConcrete();
	
	private Code feedback2 = new CodeConcrete();
	
	private Colour black = Black.getInstance();
	private Colour blue = Blue.getInstance();
	private Colour green = Green.getInstance();
	private Colour orange  = Orange.getInstance();
	private Colour purple  = Purple.getInstance();
	private Colour red  = Red.getInstance();
	private Colour white  = White.getInstance();
	private Colour yellow  = Yellow.getInstance();
	
	public Code createManualCode1(){
		Code result = new CodeConcrete();
		result.addPeg(blue);
		result.addPeg(green);
		result.addPeg(red);
		result.addPeg(orange);
		return result;
	}
	
	public Code createManualCode2(){
		Code result = new CodeConcrete();
		result.addPeg(purple);
		result.addPeg(green);
		result.addPeg(purple);
		result.addPeg(orange);
		return result;
	}
	
	
	

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}	
	
	/*
	@Test
	public void out() {
		System.out.print("hello");
		assertEquals("hello", outContent.toString());
	}
	
	*/
	
	/** 
	* Passing a predefined CODE instance to the display method. Testing that the
	* output should match BGRO, since the colors in the Code are Blue, Green, Red,
	* Orange.
	*/ 
	@Test
	public void testDisplayCodeI() {
		displayer.displayCode(createManualCode1());
		assertEquals("BGRO", outContent.toString());
	}
	
	/**
	* Same test as above, but testing that the output is not lowercase. 
	*/
	@Test
	public void testDisplayCodeIII() {
		displayer.displayCode(createManualCode1());
		assertThat("bgro", not(equalTo(outContent.toString())));
	}
	
	
	/** 
	* Passing a predefined CODE instance to the display method. Testing that the
	* output should match PGPO, since the colors in the Code are Purple, Green, Purple,
	* Orange.
	*/ 
	@Test
	public void testDisplayCodeII() {
		displayer.displayCode(createManualCode2());
		assertEquals("PGPO", outContent.toString());
	}
	
	
	
	
	
	
	
	
	
	/*
	@Test
	public void practice() {
		showcode = true;
		secretcode.addPeg(blue);
		secretcode.addPeg(green);
		secretcode.addPeg(red);
		secretcode.addPeg(orange);
		
		guess1.addPeg(orange); 
		guess1.addPeg(red); 
		guess1.addPeg(green); 
		guess1.addPeg(green); 
		
		feedback1.addPeg(white);
		feedback1.addPeg(white);
		feedback1.addPeg(white);
		feedback1.addPeg(white);
		
		guesses.add(guess1);
		feedback.add(feedback1);
		
		displayer.setShowcode(showcode);
		displayer.setSecretcode(secretcode);
		displayer.setFeedback(feedback);
		displayer.setGuesses(guesses);
		
		//displayer.displayCode(secretcode);
		
		displayer.displayGame();
		
		assertEquals(1,1);
	}
	
	*/


}
