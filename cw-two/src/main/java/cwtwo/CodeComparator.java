package cwtwo;

/**
 * An interface that compares two codes.
 */
public interface CodeComparator extends CodeGenerator {
	
	/**
	 * Compares two colors entered as parameters.
	 * @param input1 . The first code to compare.
	 * @param Input2 . The second code to compare.
	 */
	void useCodes (Code input1, Code Input2);

}
