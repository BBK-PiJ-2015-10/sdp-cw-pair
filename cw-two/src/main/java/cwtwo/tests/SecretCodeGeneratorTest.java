package cwtwo.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;

import cwtwo.CodeGenerator;
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
import cwtwo.ColorBank;

import cwtwo.Code;
import cwtwo.CodeConcrete;


public class SecretCodeGeneratorTest {
	
		
	Injector injector = Guice.createInjector(new MastermindModule());
	
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
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*  Below are the tests related to the GenerateCode() method.
	*/
	
	
	/** 
	* Testing that the Random code generator has a size of 4 pegs.
	*/
	@Test
	public void testGenerateCodeSize (){
		assertEquals(pegs.intValue(),secretGenerator.generateCode(colorBank,pegs).getCode().size());
	}
	
	
	/** 
	* Running the GenerateCode 100 times and testing that all the Colours from the selection list
	* have been randomly generated at least once.
	*/
	@Test
	public void testGenerateCodeRandom (){
		Code temp = new CodeConcrete();
		List<Colour> result = new ArrayList<>();
		for (int i=0;i<100;i++) {
			temp = secretGenerator.generateCode(colorBank,pegs);	
			for (int j=0;j<temp.getCode().size();j++){
				result.add(temp.getCode().get(j));
			}
		}
		assertEquals(true,result.containsAll(colorList));
	}
	
	
	/** 
	* Running the GenerateCode 1000 times and testing that the first color in Color list is generated between 100 to 700
	* times. If not, it is very unlikely that this distribution is truly random.
	*/
	@Test
	public void testGenerateCodeRandomDistributionFirstColor (){
		int distribution = 0;
	    Boolean isRandom = false;
		Code temp = new CodeConcrete();
		List<Colour> result = new ArrayList<>();
		for (int i=0;i<1000;i++) {
			temp = secretGenerator.generateCode(colorBank,pegs);			
			for (int j=0;j<temp.getCode().size();j++){
				result.add(temp.getCode().get(j));
				if (temp.getCode().get(j) == colorList.get(0)) {
					distribution++;
				}
			}
		}
		if ((distribution >= 100 ) && (distribution <= 730)){
			isRandom = true;
		}
		assertEquals(true,isRandom);
	}
	
	
	/** 
	* Running the GenerateCode 1000 times and testing that the second color in Color list is generated between 100 to 700
	* times. If not, it is very unlikely that this distribution is truly random.
	*/
	@Test
	public void testGenerateCodeRandomDistributionSecondColor (){
		int distribution = 0;
	    Boolean isRandom = false;
		Code temp = new CodeConcrete();
		List<Colour> result = new ArrayList<>();
		for (int i=0;i<1000;i++) {
			temp = secretGenerator.generateCode(colorBank,pegs);			
			for (int j=0;j<temp.getCode().size();j++){
				result.add(temp.getCode().get(j));
				if (temp.getCode().get(j) == colorList.get(1)) {
					distribution++;
				}
			}
		}
		if ((distribution >= 100 ) && (distribution <= 730)){
			isRandom = true;
		}
		assertEquals(true,isRandom);
	}
	
	/** 
	* Running the GenerateCode 1000 times and testing that the third color in Color list is generated between 100 to 700
	* times. If not, it is very unlikely that this distribution is truly random.
	*/
	@Test
	public void testGenerateCodeRandomDistributionThirdColor (){
		int distribution = 0;
	    Boolean isRandom = false;
		Code temp = new CodeConcrete();
		List<Colour> result = new ArrayList<>();
		for (int i=0;i<1000;i++) {
			temp = secretGenerator.generateCode(colorBank,pegs);			
			for (int j=0;j<temp.getCode().size();j++){
				result.add(temp.getCode().get(j));
				if (temp.getCode().get(j) == colorList.get(2)) {
					distribution++;
				}
			}
		}
		if ((distribution >= 100 ) && (distribution <= 730)){
			isRandom = true;
		}
		assertEquals(true,isRandom);
	}
	
	/** 
	* Running the GenerateCode 1000 times and testing that the fourth color in Color list is generated between 100 to 700
	* times. If not, it is very unlikely that this distribution is truly random.
	*/
	@Test
	public void testGenerateCodeRandomDistributionFourthColor (){
		int distribution = 0;
	    Boolean isRandom = false;
		Code temp = new CodeConcrete();
		List<Colour> result = new ArrayList<>();
		for (int i=0;i<1000;i++) {
			temp = secretGenerator.generateCode(colorBank,pegs);			
			for (int j=0;j<temp.getCode().size();j++){
				result.add(temp.getCode().get(j));
				if (temp.getCode().get(j) == colorList.get(3)) {
					distribution++;
				}
			}
		}
		if ((distribution >= 100 ) && (distribution <= 730)){
			isRandom = true;
		}
		assertEquals(true,isRandom);
	}
	
	/** 
	* Running the GenerateCode 1000 times and testing that the fifth color in Color list is generated between 100 to 700
	* times. If not, it is very unlikely that this distribution is truly random.
	*/
	@Test
	public void testGenerateCodeRandomDistributionFifthColor (){
		int distribution = 0;
	    Boolean isRandom = false;
		Code temp = new CodeConcrete();
		List<Colour> result = new ArrayList<>();
		for (int i=0;i<1000;i++) {
			temp = secretGenerator.generateCode(colorBank,pegs);			
			for (int j=0;j<temp.getCode().size();j++){
				result.add(temp.getCode().get(j));
				if (temp.getCode().get(j) == colorList.get(4)) {
					distribution++;
				}
			}
		}
		if ((distribution >= 100 ) && (distribution <= 730)){
			isRandom = true;
		}
		assertEquals(true,isRandom);
	}
	
	/** 
	* Running the GenerateCode 1000 times and testing that the sixth color in Color list is generated between 100 to 700
	* times. If not, it is very unlikely that this distribution is truly random.
	*/
	@Test
	public void testGenerateCodeRandomDistributionSixthColor (){
		int distribution = 0;
	    Boolean isRandom = false;
		Code temp = new CodeConcrete();
		List<Colour> result = new ArrayList<>();
		for (int i=0;i<1000;i++) {
			temp = secretGenerator.generateCode(colorBank,pegs);			
			for (int j=0;j<temp.getCode().size();j++){
				result.add(temp.getCode().get(j));
				if (temp.getCode().get(j) == colorList.get(5)) {
					distribution++;
				}
			}
		}
		if ((distribution >= 100 ) && (distribution <= 730)){
			isRandom = true;
		}
		assertEquals(true,isRandom);
	}
	
	
	
	
	
	

}
