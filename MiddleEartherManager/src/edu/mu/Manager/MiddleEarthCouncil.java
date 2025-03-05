package edu.mu.Manager;

public class MiddleEarthCouncil {
	private static MiddleEarthCouncil instance;
	
	private MiddleEarthCouncil() {
		
	}
	
	private MiddleEarthCouncil getInstance() {
		if(instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	public CharacterManager getCharacterManager() {
		return instance.getCharacterManager();
	}
}
