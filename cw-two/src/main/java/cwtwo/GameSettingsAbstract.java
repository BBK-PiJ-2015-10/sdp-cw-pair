package cwtwo;
import java.awt.*;
import java.util.List;

public abstract class GameSettingsAbstract {
	
	List<Color> colours;
	
	List<Color> pegColours;
	
	int numPegs;
	
	int numTurns;
	
	public List<Color> getColours(){
		return this.colours;
	}
	
	public List<Color> getpegColours(){
		return this.pegColours;
	}
	
	public int getNumPegs(){
		return this.numPegs;
	}
	
	public int getNumTurns(){
		return this.numTurns;
	}

	
}
