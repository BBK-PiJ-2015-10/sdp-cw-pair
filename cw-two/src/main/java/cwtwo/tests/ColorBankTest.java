package cwtwo.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import cwtwo.colors.Black;
import cwtwo.colors.Blue;
import cwtwo.colors.Colour;
import cwtwo.colors.Green;
import cwtwo.colors.Orange;
import cwtwo.colors.Purple;
import cwtwo.colors.Red;
import cwtwo.colors.White;
import cwtwo.colors.Yellow;
import cwtwo.ColorBank;


public class ColorBankTest {

	private Colour black = Black.getInstance();
	
	private Colour white = White.getInstance();
	
	private Colour blue = Blue.getInstance();
	
	private Colour green = Green.getInstance();
	
	private Colour orange = Orange.getInstance();
	
	private Colour yellow = Yellow.getInstance();
	
	private Colour purple = Purple.getInstance();
	
	private Colour red = Red.getInstance();
	
	private List<Colour> testFullColours = Arrays.asList(
			blue,red,yellow,purple,orange,green);
	
	private List<Colour> testEmptyColours = Arrays.asList();
	
    private Colour[] testFullRightAlmost = new Colour[]{
			white,
			black};
    
	private ColorBank test1ColorBank = new ColorBank(testFullColours,testFullRightAlmost);
	
	private ColorBank test2ColorBank = new ColorBank(testEmptyColours,testFullRightAlmost);
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the fillColorBank() method, this method is enclosed in
	*  the constructor of the ColorBank Class.
	*/
	
	
	/** 
	* Creating two instances of ColorBank one full(6 colors) and one empty(no colors). Comparing
	* the size differential of both Colors. By doing so, implicitly comparing the fillColorBank method.
	*/
	@Test
	public void testfillColorBankTestColors() {
		ColorBank full = new ColorBank(testFullColours,testFullRightAlmost);
		int initialsizefull = full.numColors();
		ColorBank half = new ColorBank(testEmptyColours,testFullRightAlmost);
		int initialsizeempty = half.numColors();
		int colorsadded = initialsizefull-initialsizeempty;
		assertEquals(6,colorsadded);
	}
	
	/** 
	* Creating an instance of ColorBank and testing that fillColorBank worked by testing if the
	* getRight method gives a valid outcome. In this case, Black.
	*/ 
	@Test
	public void testfillColorBankRight() {
		ColorBank full = new ColorBank(testFullColours,testFullRightAlmost);
		assertEquals(black,full.getRight());
	}
	
	/** 
	* Creating an instance of ColorBank and testing that fillColorBank worked by testing if the
	* getRight method gives a valid outcome. In this case, White.
	*/ 
	@Test
	public void testfillColorBankAlmost() {
		ColorBank full = new ColorBank(testFullColours,testFullRightAlmost);
		assertEquals(white,full.getAlmost());
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the getColour(int index) method.
	*/
	
	
	/** 
	* Creating a List of only one color, using that List to create an instance of ColorBank.
	* Testing that getColour for position 0 gives me that color that I have in the list.
	*/
	@Test
	public void testgetColourOneColorList() {	
		List<Colour> tempColourList = new ArrayList<>();
		tempColourList.add(blue);
		ColorBank tempColorBank = new ColorBank(tempColourList,testFullRightAlmost);	
		assertEquals("Blue",tempColorBank.getColour(0).getName());
	}		
	
	/** 
	* Using the private field test1ColorBank and testing that the getColour method
	* will give me all the Colors in that ColorBank.
	*/
	@Test
	public void testgetColourMultipleColorList() {	
		List<Colour> result = new ArrayList<>();
		for (int i=0;i<test1ColorBank.numColors();i++) {
			result.add(test1ColorBank.getColour(i));
		}
		assertEquals(true,result.containsAll(testFullColours));
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the getColourByKey(Character key) method.
	*/
	
	
	/** 
	* Using the private field test1ColorBank and testing that the getColourByKey method
	* and testing that key B will give a Blue.
	*/
	@Test
	public void testgetColourByKeyExpectingBlue() {	
		assertEquals(blue,test1ColorBank.getColourByKey('B'));
	}
	
	/** 
	* Using the private field test1ColorBank and testing that the getColourByKey method
	* and testing that key R will give a Red.
	*/
	@Test
	public void testgetColourByKeyExpectingRed() {	
		assertEquals(red,test1ColorBank.getColourByKey('R'));
	}
	
	/** 
	* Using the private field test1ColorBank and testing that the getColourByKey method
	* and testing that key Y will give a Yellow.
	*/
	@Test
	public void testgetColourByKeyExpectingYellow() {	
		assertEquals(yellow,test1ColorBank.getColourByKey('Y'));
	}

	/** 
	* Using the private field test1ColorBank and testing that the getColourByKey method
	* and testing that key P will give a Purple.
	*/
	@Test
	public void testgetColourByKeyExpectingPurple() {	
		assertEquals(purple,test1ColorBank.getColourByKey('P'));
	}
	
	/** 
	* Using the private field test1ColorBank and testing that the getColourByKey method
	* and testing that key O will give an Orange.
	*/
	@Test
	public void testgetColourByKeyExpectingOrange() {	
		assertEquals(orange,test1ColorBank.getColourByKey('O'));
	}
	
	/** 
	* Using the private field test1ColorBank and testing that the getColourByKey method
	* and testing that key G will give a Green.
	*/
	@Test
	public void testgetColourByKeyExpectingGreen() {	
		assertEquals(green,test1ColorBank.getColourByKey('G'));
	}
	
	/** 
	* Using the private field test1ColorBank and testing that the getColourByKey method
	* and testing that if passing a non valid key retrieves a null.
	*/
	@Test
	public void testgetColourByKeyExpectingNull() {	
		assertEquals(null,test1ColorBank.getColourByKey('g'));
	}
	
	/** 
	* Using the private field test1ColorBank and testing that the getColourByKey method
	* and testing that if passing an empty key retrieves a null.
	*/
	@Test
	public void testgetColourByKeyExpectingNullEmptyKey() {	
		assertEquals(null,test1ColorBank.getColourByKey(' '));
	}
	

///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the getColours() method.
	*/
	
	
	/** 
	* Using the private field test1ColorBank and testing that the getColours method
	* and testing that the List of Colors retrieved contains all the elements of
	* the list of Colors testFullColours, this is the list used in the constructor
	* of test1ColorBank creation.
	*/
	@Test
	public void testgetColoursFullColours() {	
		assertEquals(true,(test1ColorBank.getColours()).containsAll(testFullColours));
	}	
	
	
	/** 
	* Using the private field test2ColorBank and testing that the getColours method
	* and testing that the List of Colors retrieved is empty, since the list used
	* to create test2ColorBank was empty.
	*/
	@Test
	public void testgetColoursEmptyColours() {	
		assertEquals(true,test2ColorBank.getColours().isEmpty());
	}	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the getRight() and getAlmost() methods.
	*/
	
	
	/** 
	* Using the private field test1ColorBank and testing that the getRight method
	* gives you a Color type Black.
	*/
	@Test
	public void testgetRight() {	
		assertEquals(black,test1ColorBank.getRight());
	}		
	
	/** 
	* Using the private field test1ColorBank and testing that the getAlmost method
	* gives you a Color type White.
	*/
	@Test
	public void testgetAlmost() {	
		assertEquals(white,test1ColorBank.getAlmost());
	}	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the numColors() method. This will yield the number of colors - 1.
	*/


	/** 
	* Using the private field test1ColorBank and testing that the numColors() will yield.
	*/
	@Test
	public void testnumColorsFull() {	
		assertEquals(6,test1ColorBank.numColors());
	}
	
	
	/** 
	* Using the private field test2ColorBank(Empty list) and testing that the numColors() will yield 0.
	*/
	@Test
	public void testnumColorsEmpty() {	
		assertEquals(0,test2ColorBank.numColors());
	}
	
			
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
}
