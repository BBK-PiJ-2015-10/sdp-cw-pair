
package cwtwo;

import cwtwo.colors.Colour;

import java.util.List;

public interface Greeter {

	void settings(int numPegs, List<Colour> colors, int turns);
	
	void greet();
	
}
