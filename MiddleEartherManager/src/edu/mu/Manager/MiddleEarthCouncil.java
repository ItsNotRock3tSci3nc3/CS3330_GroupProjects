package edu.mu.Manager;


public class MiddleEarthCouncil {
	
    private static MiddleEarthCouncil instance;

    private CharacterManager manager;
 
    private MiddleEarthCouncil() { // Ensure Singleton use 
        manager = new CharacterManager();
    }

    public static MiddleEarthCouncil getInstance() {
        if (instance == null) {
            instance = new MiddleEarthCouncil();
        }
        return instance;
    }

    public CharacterManager getCharacterManager() {
        return manager;
    }
}