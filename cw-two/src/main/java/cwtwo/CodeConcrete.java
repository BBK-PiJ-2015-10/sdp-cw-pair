package cwtwo;

import cwtwo.colors.Colour;

import java.util.ArrayList;
import java.util.List;

public class CodeConcrete implements Code {
	
	private List<Colour> code = new ArrayList<>();

	public void addPeg(Colour peg){
		this.code.add(peg);
	}

	@Override
	public List<Colour> getCode() {
		return this.code;
	}


}
