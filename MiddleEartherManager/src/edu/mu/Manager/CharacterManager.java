package edu.mu.Manager;
import edu.mu.Characters.*;

/**
 * Class to manage MiddleEarthCharacter list
 */
public class CharacterManager {

    MiddleEarthCharacter[] characters;
    int size;
    
    /**
     * Constructor: initialize MiddleEarthCharacter list with length 5
     * Keep track of number of characters with size
     */
    public CharacterManager() {
        this.characters = new MiddleEarthCharacter[5];
        this.size = 0;
    }
    
    /**
     * Add character method
     * @param c
     * MiddleEarthCharacter object
     * @return true or false,
     * true if successful, false if not 
     */
    public boolean addCharacter(MiddleEarthCharacter c) {
        if (this.characters.length == this.size) { // check if list is full
            MiddleEarthCharacter[] temp = new MiddleEarthCharacter[characters.length]; // dynamically allocate new list with same size
            temp = characters; // copy characters to new list
            characters = new MiddleEarthCharacter[characters.length*2]; // allocate new list with double size
            characters = temp; // copy characters back over
        }
        else {
            characters[size] = c;
            System.out.println("Character " + c.getName() + " added");
            size++;
            return true;
        }
        return false;
    }
    
    /**
     * getCharacter method: Search for character
     * @param name
     * String for name
     * @return character name or null
     * if character found return name, otherwise return null
     */
    public MiddleEarthCharacter getCharacter(String name) {
        for(int i = 0; i < size; i++) {
            if (characters[i].getName().equals(name)) {
                System.out.println("Character found");
                return characters[i];
            }
        }
        System.out.println("No character found");
        return null;
    }
    
    /**
     * update character method: update characters attributes
     * @param character
     * MiddleEarthCharacter object
     * @param name
     * String for name
     * @param health
     * Double for health
     * @param power
     * Double for power
     * @return true or false
     * 
     */
    public boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
    	
    	 // Update character
        character.setName(name);
        character.setHealth(health);
        character.setPower(power);
    	
    	// checks if all attributes are equal, if so, there is no change, return false
        if(character == null || (character.getName().equals(name) && character.getHealth() == health && character.getPower() == power)) {
            return false;
        }
        
        return true; // return true if change
    }
    
    /**
     * delete character method 
     * @param character
     * MiddleEarthCharacter object
     * @return true or false
     * true if character was removed, false if not
     */
    public boolean deleteCharacter(MiddleEarthCharacter character) {
    	System.out.println("Deleting character: " + character.getName());
        for (int i = 0; i < size; i++) {
            if (this.characters[i] == character) { // if character found
                for (int j = i; j < size - 1; j++) {
                    this.characters[j] = this.characters[j+1]; // move remaining characters to the left
                }
                this.characters[size - 1] = null; // remove character
                size--;
                System.out.println("Successfully deleted character!");
                return true;
            }
        }
        System.out.println("Could not delete character");
        return false;
    }
    
    /**
     * display characters method
     * displays all characters in a MiddleEarthCharacter list
     */
    public void displayAllCharacters() {
        for(int i = 0; i < size; i++) {
            System.out.println(characters[i].displayInfo());
        }
    }
}