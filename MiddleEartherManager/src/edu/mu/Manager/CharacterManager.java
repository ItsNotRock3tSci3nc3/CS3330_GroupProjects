package edu.mu.Manager;
import edu.mu.Characters.*;

public class CharacterManager {

	MiddleEarthCharacter[] characters;
	int size;
	
	public CharacterManager() {
		this.characters = new MiddleEarthCharacter[5];
		this.size = 0;
	}
	
	public boolean addCharacter(MiddleEarthCharacter c) {
		if(this.characters.length == this.size) {
			MiddleEarthCharacter[] temp = new MiddleEarthCharacter[characters.length];
			temp = characters;
			characters = new MiddleEarthCharacter[characters.length*2];
			characters = temp;
			
			//error checking
			System.out.println("Array size doubled, returning false. Character array length: " + characters.length);
			
			return false;
		}
		else {
			size++;
			characters[size]=c;
			System.out.println("Character added at index " + size);
			return true;
		}
	}
	
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i = 0; i < size; i++) {
			if(characters[i].getName() == name) {
				System.out.println("Character found");
				return characters[i];
			}
		}
		System.out.println("No character found");
		return null;
	}
	
	public boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
		if(character == null || character.getName()==name && character.getHealth()==health && character.getPower()==power) {
			return false;
		}
		
		character.setName(name);
		character.setHealth(health);
		character.setPower(power);
		return true;
		
	}
	
	
	public void displayAllCharacters() {
		for(int i =0; i<size; i++) {
			System.out.println(characters[i].displayInfo());
		}
	}
	
	
	
	
	
}