package cwtwo.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

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


public class MastermindDisplayerTest {
	
	private Displayer displayer = new MastermindDisplayer();

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
	
	public Code createManualFeedback1(){
		Code result = new CodeConcrete();
		result.addPeg(white);
		result.addPeg(black);
		result.addPeg(black);
		result.addPeg(black);
		return result;
	}
	
	public Code createManualFeedback2(){
		Code result = new CodeConcrete();
		result.addPeg(white);
		result.addPeg(black);
		result.addPeg(white);
		return result;
	}
	
	
	public Code createManualFeedback3(){
		Code result = new CodeConcrete();
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
	

	
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the displayCode() method.
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
	

///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the displayFeedbackCode() method.
	*/		
	
	
	/** 
	* Passing a predefined Feedback CODE instance to the displayFeedbackCode method. Testing that the
	* output should match White Black Black Black , since the colors in the Code WBBB.
	*/
	@Test
	public void testDisplayFeedbackCodeI() {
		((MastermindDisplayer)displayer).displayFeedbackCode(createManualFeedback1());
		assertEquals("White Black Black Black ", outContent.toString());
	}
	
	/** 
	* Passing a predefined Feedback CODE instance to the displayFeedbackCode method. Testing that the
	* output should match White Black White , since the colors in the Code WBW.
	*/
	@Test
	public void testDisplayFeedbackCodeII() {
		((MastermindDisplayer)displayer).displayFeedbackCode(createManualFeedback2());
		assertEquals("White Black White ", outContent.toString());
	}
	
	/** 
	* Passing a predefined Feedback CODE instance to the displayFeedbackCode method. Testing that the
	* output should match No Pegs, since the code is empty.
	*/
	@Test
	public void testDisplayFeedbackCodeIII() {
		((MastermindDisplayer)displayer).displayFeedbackCode(createManualFeedback3());
		assertEquals("No Pegs", outContent.toString());
	}
	
	
	
	
	
	
	



}
