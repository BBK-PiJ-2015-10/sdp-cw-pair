package cwtwo.tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;

import cwtwo.Code;
import cwtwo.CodeConcrete;
import cwtwo.CodeGenerator;
import cwtwo.GuessGenerator;
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

public class GuessGeneratorTest {
	
	Injector injector = Guice.createInjector(new MastermindModule());
	
	private CodeGenerator guessGenerator = injector.getInstance(Key.get(CodeGenerator.class,CodeGenerator.Guess.class));
	
	private CodeGenerator secretGenerator = injector.getInstance(Key.get(CodeGenerator.class,CodeGenerator.Secret.class));
	
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
	
	
	ColorBank colorBank = new ColorBank(colorList,feedbackColours);
	
	Integer pegs = 4;
	
	private CodeConcrete codeConcrete = new CodeConcrete();
	
	/** 
	* This is an auxiliary method that yields a random String size 4 with valid color inputs.
	*/
	public String createRandomValidString() {
		String randomValidString = "";
		Code temp = new CodeConcrete();
		temp = secretGenerator.generateCode(colorBank,pegs);	
		for (int j=0;j<temp.getCode().size();j++){
			randomValidString = randomValidString + temp.getCode().get(j).getName().substring(0,1);
		}
		return randomValidString;
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the hasValidColors() method.
	*/
	
	
	/** 
	* Testing the method with 100 random correct inputs, expecting the results to be true. 
	* If one of them is false, then Boolean result is changed to false and the test will fail.
	*/
	@Test
	public void testhasValidColorsCorrectRandom100Times (){
		Boolean result = true;
		for (int i=0;i<100;i++){
			if (!((GuessGenerator)guessGenerator).hasValidColors(createRandomValidString(),colorBank)){
				result = false;
			}
		}
		assertEquals(true,result);
	}	
	
	
	/** 
	* Testing the method by inputting an invalid String of Colors, in this case all lower case.
	* Expecting a the method to provide the output false.
	*/
	@Test
	public void testhasValidColorsIncorrectLowerCase (){
		assertEquals(false,((GuessGenerator)guessGenerator).hasValidColors("ygbr",colorBank));
	}
	
	/** 
	* Testing the method by inputting an invalid String of Colors, in this case all invalid letters.
	* Expecting a the method to provide the output false.
	*/
	@Test
	public void testhasValidColorsIncorrectInvalidLetters (){
		assertEquals(false,((GuessGenerator)guessGenerator).hasValidColors("WZLX",colorBank));
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the generateCode() method. These are all interactive tests, once running
	*  you need to input data from the user screen to be able to move forward. The input entered must be valid, otherwise
	*  you will loop until you enter a valid input. At the end, testing if the output has the correct size, is not empty,
	*  and is of valid type.
	*/
	@Test
	public void testGenerateCodeI (){
		assertEquals(4,guessGenerator.generateCode(colorBank, pegs).getCode().size());
	}
	
	
	@Test
	public void testGenerateCodeII (){
		assertEquals(false,guessGenerator.generateCode(colorBank, pegs).getCode().isEmpty());
	}
	
	@Test
	public void testGenerateCodeIII (){
		assertEquals(codeConcrete.getClass(),guessGenerator.generateCode(colorBank, pegs).getClass());
	}
	
	

}
