package cwtwo.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;

import cwtwo.Code;
import cwtwo.CodeComparator;
import cwtwo.CodeConcrete;
import cwtwo.CodeGenerator;
import cwtwo.FeedbackGenerator;
import cwtwo.ColorBank;
import cwtwo.MastermindModule;
import cwtwo.colors.Black;
import cwtwo.colors.Blue;
import cwtwo.colors.Colour;
import cwtwo.colors.Green;
import cwtwo.colors.Orange;
import cwtwo.colors.Purple;
import cwtwo.colors.Red;
import cwtwo.colors.White;
import cwtwo.colors.Yellow;

public class FeedbackGeneratorTest {
	
Injector injector = Guice.createInjector(new MastermindModule());
		
	private CodeGenerator secretGenerator = injector.getInstance(Key.get(CodeGenerator.class,CodeGenerator.Secret.class));
	
	private CodeGenerator feedbackGenerator = injector.getInstance(Key.get(CodeComparator.class,CodeGenerator.Feedback.class));
	
	private Colour black = Black.getInstance();
	
	private Colour white = White.getInstance();
	
	
		private List<Colour> colorList = Arrays.asList(
				Blue.getInstance(),
				Red.getInstance(),
				Yellow.getInstance(),
				Purple.getInstance(),
				Orange.getInstance(),
				Green.getInstance()
		);
		
		private Colour[] feedbackColours = new Colour[]{
				White.getInstance(),
				Black.getInstance()};
		
		
		private ColorBank colorBank = new ColorBank(colorList,feedbackColours);
		
		Integer pegs = 4;
		
		
		private Code createCodeConcreteAllBlue () {
			CodeConcrete result = new CodeConcrete();
			result.addPeg(colorBank.getColourByKey('B'));
			result.addPeg(colorBank.getColourByKey('B'));
			result.addPeg(colorBank.getColourByKey('B'));
			result.addPeg(colorBank.getColourByKey('B'));
			return result;
		}
		
		private Code createCodeConcreteAllYellow () {
			Code result = new CodeConcrete();
			result.addPeg(colorBank.getColourByKey('Y'));
			result.addPeg(colorBank.getColourByKey('Y'));
			result.addPeg(colorBank.getColourByKey('Y'));
			result.addPeg(colorBank.getColourByKey('Y'));
			return result;
		}
		
		private Code createCodeConcrete3Yellow1Green () {
			Code result = new CodeConcrete();
			result.addPeg(colorBank.getColourByKey('Y'));
			result.addPeg(colorBank.getColourByKey('Y'));
			result.addPeg(colorBank.getColourByKey('G'));
			result.addPeg(colorBank.getColourByKey('Y'));
			return result;
		}
		
		private Code createCodeConcrete1B1G1P1R () {
			Code result = new CodeConcrete();
			result.addPeg(colorBank.getColourByKey('B'));
			result.addPeg(colorBank.getColourByKey('G'));
			result.addPeg(colorBank.getColourByKey('P'));
			result.addPeg(colorBank.getColourByKey('R'));
			return result;
		}
		
		private Code createCodeConcrete1B1P1P1R () {
			Code result = new CodeConcrete();
			result.addPeg(colorBank.getColourByKey('B'));
			result.addPeg(colorBank.getColourByKey('P'));
			result.addPeg(colorBank.getColourByKey('P'));
			result.addPeg(colorBank.getColourByKey('R'));
			return result;
		}
		
		
		private Code createCodeConcrete4R () {
			Code result = new CodeConcrete();
			result.addPeg(colorBank.getColourByKey('R'));
			result.addPeg(colorBank.getColourByKey('R'));
			result.addPeg(colorBank.getColourByKey('R'));
			result.addPeg(colorBank.getColourByKey('R'));
			return result;
		}
		
		
		
		
		

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	/**
	*  Below are the tests related to the generateCode() method.
	*/
	
	
	/** 
	* Testing the method by comparing two identical Codes. The counter variable keeps track on how many
	* black colors are received as feedback. Testing that the number equals to 4.
	*/
	@Test
	public void testgenerateCodeIdenticalGuessSecret (){
		int counter =0;
		Code temp1 = new CodeConcrete();
		Code temp2 = secretGenerator.generateCode(colorBank, pegs);
		Code temp3= temp2;		
		((FeedbackGenerator)feedbackGenerator).useCodes(temp2,temp3);
		temp1 = feedbackGenerator.generateCode(colorBank, pegs);
		for (int j=0;j<temp1.getCode().size();j++){
			if (temp1.getCode().get(j) == black) {
				counter ++;
			}
		}
		assertEquals(4,counter);
	}		
	
	
	/** 
	* Testing the method by comparing two Codes that have no similar elements at all. 
	* One is all blue, and the second one is all yellow.
	* Testing that that Feedback code provided has no colors on it (is empty).
	*/
	@Test
	public void testgenerateCodeCompletelyDifferentGuessSecret (){
		Code temp1 = new CodeConcrete();
		Code temp2 = createCodeConcreteAllBlue ();
		Code temp3 = createCodeConcreteAllYellow ();		
		((FeedbackGenerator)feedbackGenerator).useCodes(temp2,temp3);
		temp1 = feedbackGenerator.generateCode(colorBank, pegs);
		assertEquals(true,temp1.getCode().isEmpty());
	}
	
	
	/** 
	* Testing the method by comparing two Codes. The secret code has 4 yellows, the guess has
	* 3 yellows and 1 green. I am expecting to receive 3 black colors as feedback. 
	* Testing that the counter variable equals to 3.
	*/
	@Test
	public void testgenerateCodeOneColorDifferentPartI (){
		int counter =0;
		Code temp1 = new CodeConcrete();
		Code temp2 = createCodeConcreteAllYellow ();
		Code temp3 = createCodeConcrete3Yellow1Green ();		
		((FeedbackGenerator)feedbackGenerator).useCodes(temp2,temp3);
		temp1 = feedbackGenerator.generateCode(colorBank, pegs);
		for (int j=0;j<temp1.getCode().size();j++){
			if (temp1.getCode().get(j) == black) {
				counter ++;
			}
		}
		assertEquals(3,counter);
	}	
	
	
	/** 
	* Same test as the one above, but this case I am testing that the peg that wasn't in
	* the secretcode doesn't generate a peg. Meaning, I am testing that size of the feedback
	* is equal to 3.
	*/
	@Test
	public void testgenerateCodeOneColorDifferentPartII (){
		Code temp1 = new CodeConcrete();
		Code temp2 = createCodeConcreteAllYellow ();
		Code temp3 = createCodeConcrete3Yellow1Green ();		
		((FeedbackGenerator)feedbackGenerator).useCodes(temp2,temp3);
		temp1 = feedbackGenerator.generateCode(colorBank, pegs);
		assertEquals(3,temp1.getCode().size());
	}
	
	/** 
	* Testing with a guess code that only has one common element with the secret code, but
	* not in the proper position. In this Part I, testing that the size of the feedback is only
	* 1 element long.
	*/
	@Test
	public void testgenerateCodeOneColorinCommonPartI (){
		Code temp1 = new CodeConcrete();
		Code temp2 = createCodeConcrete3Yellow1Green ();
		Code temp3 =  createCodeConcrete1B1G1P1R ();		
		((FeedbackGenerator)feedbackGenerator).useCodes(temp2,temp3);
		temp1 = feedbackGenerator.generateCode(colorBank, pegs);
		assertEquals(1,temp1.getCode().size());
	}
	
	/** 
	* Continuation of above test. In this Part II, testing that the element included
	* in the feedback is a white color.
	*/
	@Test
	public void testgenerateCodeOneColorinCommonPartII (){
		int counter =0;
		Code temp1 = new CodeConcrete();
		Code temp2 = createCodeConcrete3Yellow1Green ();
		Code temp3 =  createCodeConcrete1B1G1P1R ();		
		((FeedbackGenerator)feedbackGenerator).useCodes(temp2,temp3);
		temp1 = feedbackGenerator.generateCode(colorBank, pegs);
		for (int j=0;j<temp1.getCode().size();j++){
			if (temp1.getCode().get(j) == white) {
				counter ++;
			}
		}
		assertEquals(1,counter);
	}
	
	
	/** 
	* Testing that the feedback generated is sorted. In this particular case the guess
	* code has 4R and the secret code is BGPR. I am testing that the fourth element of
	* the feedback code is not a black peg. Otherwise, the code wouldn't be sorted.
	*/
	@Test
	public void testgenerateCodeOneSortingType1(){
		Code temp1 = new CodeConcrete();
		Code temp2 = createCodeConcrete1B1G1P1R();
		Code temp3 = createCodeConcrete4R(); 		
		((FeedbackGenerator)feedbackGenerator).useCodes(temp2,temp3);
		temp1 = feedbackGenerator.generateCode(colorBank, pegs);
		assertThat(black, not(equalTo(temp1.getCode().get(3))));
	}
	
	/** 
	* Similar test as above but in this case, 3 of the codes are correct, but the
	* second one is in the wrong position. Testing that in the feedback provided the 
	* second element of it is not a white peg. Otherwise, the feedback wouldn't be sorted.
	*/
	@Test
	public void testgenerateCodeOneSortingType2(){
		Code temp1 = new CodeConcrete();
		Code temp2 = createCodeConcrete1B1G1P1R();
		Code temp3 =  createCodeConcrete1B1P1P1R(); 		
		((FeedbackGenerator)feedbackGenerator).useCodes(temp2,temp3);
		temp1 = feedbackGenerator.generateCode(colorBank, pegs);
		assertThat(white, not(equalTo(temp1.getCode().get(1))));
	}
	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		
	

}
