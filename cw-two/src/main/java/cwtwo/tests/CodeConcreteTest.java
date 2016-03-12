package cwtwo.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cwtwo.Code;
import cwtwo.CodeConcrete;
import cwtwo.colors.Blue;
import cwtwo.colors.Colour;
import cwtwo.colors.Green;
import cwtwo.colors.Orange;
import cwtwo.colors.Purple;
import cwtwo.colors.Red;
import cwtwo.colors.Yellow;

public class CodeConcreteTest {
	
	private static Colour blue = Blue.getInstance();
	private static Colour green = Green.getInstance();
	private static Colour orange  = Orange.getInstance();
	private static Colour purple  = Purple.getInstance();
	private static Colour red  = Red.getInstance();
	private static Colour yellow  = Yellow.getInstance();
	private static Code code = new CodeConcrete();
	private static Code codeTester2 = new CodeConcrete();
	
	
	/** 
	* This is an auxiliary static method to facilitate the testing of the different methods of
	* the Concrete Class. It takes an input of type Code and it adds four pegs.
	*/
	private static void createCodeSize4 (Code input) {
		input.addPeg(orange);
		input.addPeg(purple);
		input.addPeg(red);
		input.addPeg(yellow);
	}
	
	
	@Before
	public void setup(){
		code = new CodeConcrete();
		codeTester2 = new CodeConcrete();
	}
	
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the addPeg method.
	*/

	
	/** 
	* Testing that the size of the List<Colour> increases by one when a peg is added.
	*/
	@Test
	public void testaddPegCorrectSize() {
		int initialsize = code.getCode().size();
		code.addPeg(blue);
		assertEquals(initialsize+1,code.getCode().size());
	}
	
	/** 
	* Testing that the size of the List<Colour> increases by one when a peg is added.
	* In this case, I am testing that it can add 4 pegs.
	*/
	@Test
	public void testaddPegCorrectSize4Pegs() {
		int initialsize = code.getCode().size();
		code.addPeg(blue);
		code.addPeg(blue);
		code.addPeg(green);
		code.addPeg(yellow);
		assertEquals(initialsize+4,code.getCode().size());
	}
	
	
	/** 
	* Testing that the color added was properly added. In this case, adding a blue
	* colour and assserting if I get the element added from the list, if it matches that color.
	*/
	@Test
	public void testaddPegCorrect() {
		code.addPeg(blue);
		assertEquals(Blue.getInstance(),code.getCode().get(0));
	}	
	
//////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the getCode() method.
	*/
	
	
	/** 
	* Testing to get the Code of a CodeConcrete class that has an empty list. Asserting
	* that the size of the List<Colour> returned is zero.
	*/
	@Test
	public void testgetCodeCorrect() {
	assertEquals(0,code.getCode().size());
	}	
	
	
	/** 
	* Starting with a CodeConcrete that is empty, adding 4 Colour Pegs and checking that
	* getCode will retrieve me a List<Colour> with a size 4.
	*/
	@Test
	public void testgetCodeCorrectwith4PegsTestingSize() {
		CodeConcreteTest.createCodeSize4(code);
		assertEquals(4,code.getCode().size());
	}
	
	/** 
	* Starting with two CodeConcretes instances that are empty, adding the same 4 Colours to each
	* testing that that getCode() elements retrieved are the same for both instances of CodeConcrete.
	*/
	@Test
	public void testgetCodeCorrectwith4PegsTestingFirstPeg() {
		CodeConcreteTest.createCodeSize4(code);
		CodeConcreteTest.createCodeSize4(codeTester2);
		assertEquals(codeTester2.getCode().get(0),code.getCode().get(0));
	}
	
	/** 
	* Starting with two CodeConcretes instances that are empty, adding the same 4 Colours to each
	* testing that that getCode() elements retrieved are the same for both instances of CodeConcrete.
	*/
	@Test
	public void testgetCodeCorrectwith4PegsTestingSecondPeg() {
		CodeConcreteTest.createCodeSize4(code);
		CodeConcreteTest.createCodeSize4(codeTester2);
		assertEquals(codeTester2.getCode().get(1),code.getCode().get(1));
	}
	
	/** 
	* Starting with two CodeConcretes instances that are empty, adding the same 4 Colours to each
	* testing that that getCode() elements retrieved are the same for both instances of CodeConcrete.
	*/
	@Test
	public void testgetCodeCorrectwith4PegsTestingThirdPeg() {
		CodeConcreteTest.createCodeSize4(code);
		CodeConcreteTest.createCodeSize4(codeTester2);
		assertEquals(codeTester2.getCode().get(2),code.getCode().get(2));
	}
	
	/** 
	* Starting with two CodeConcretes instances that are empty, adding the same 4 Colours to each
	* testing that that getCode() elements retrieved are the same for both instances of CodeConcrete.
	*/
	@Test
	public void testgetCodeCorrectwith4PegsTestingFourthPeg() {
		CodeConcreteTest.createCodeSize4(code);
		CodeConcreteTest.createCodeSize4(codeTester2);
		assertEquals(codeTester2.getCode().get(3),code.getCode().get(3));
	}
	

//////////////////////////////////////////////////////////////////////////////////////////////
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
