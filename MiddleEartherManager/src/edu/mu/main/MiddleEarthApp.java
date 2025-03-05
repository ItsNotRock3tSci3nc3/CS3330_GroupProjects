package edu.mu.main;
import edu.mu.Characters.*;
import edu.mu.Manager.*;

public class MiddleEarthApp {
	public static void main(String[] args) {
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager manager = council.getCharacterManager();
		
		manager.addCharacter(new Human("Kaleb", 100, 25));
		manager.addCharacter(new Human("Cole", 100, 25));
		manager.addCharacter(new Wizard("Supreet", 80, 50));
				
		MiddleEarthCharacter kaleb = manager.getCharacter("Kaleb");
		MiddleEarthCharacter cole = manager.getCharacter("Cole");
		MiddleEarthCharacter supreet = manager.getCharacter("Supreet");
		
		manager.displayAllCharacters();
		
		manager.deleteCharacter(kaleb);
	
		manager.updateCharacter(cole, "Cole", 100, 30);
		
		manager.displayAllCharacters();
		
		
		if (cole != null && supreet != null) {
			cole.attack(supreet);
			supreet.attack(cole);
		}
			
		manager.displayAllCharacters();
	}
}
