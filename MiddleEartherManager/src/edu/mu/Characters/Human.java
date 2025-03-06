package edu.mu.Characters;

/**
 * Human: A instance of the MiddleEarthCharacter class
 */
public class Human extends MiddleEarthCharacter{
	
	/**
	 * Super constructor for Human
	 * Sets a Humans attributes
	 * @param name
	 * @param health
	 * @param power
	 */
	public Human(String name, double health, double power) {
		super(name, health, power);
	}
	
	/**
	 * Takes a target and determines what a Human can attack
	 * @param target
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Human || target instanceof Orc) {
			return false;
		}
		
		if (target instanceof Wizard) {
			this.power = 1.5;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns race of MiddleEarthCharacter
	 */
	public String getRace() {
		return "Human";
	}
}