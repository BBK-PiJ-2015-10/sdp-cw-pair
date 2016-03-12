package cwtwo;
public class Settings extends GameSettingsAbstract {
	
	private static Settings settings = new Settings();
	
	private Settings(){
		

		this.numPegs = 4;
		this.numTurns = 12;
		
	}

	public static Settings getInstance(){
		return settings;
	}
	
}
