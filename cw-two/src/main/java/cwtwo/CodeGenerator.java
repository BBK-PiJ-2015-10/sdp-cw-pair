package cwtwo;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * An interface that generates codes based on colorbank and a specified number of pegs. 
 */
public interface CodeGenerator {

	/**
	 * Returns a code based on the number of pegs and the colors in the colorbank.
	 * @param colorBank . A colorbank with all the available color options.
	 * @param pegs . The number of pegs in the code.
	 * @return Code. A code generated from the colorbank options and peg size.
	 */
	Code generateCode(ColorBank colorBank,Integer pegs);

	@BindingAnnotation
	@Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
	public @interface Secret {}

	@BindingAnnotation
	@Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
	public @interface Feedback {}

	@BindingAnnotation
	@Target({ FIELD, PARAMETER, METHOD }) @Retention(RUNTIME)
	public @interface Guess {}



}
