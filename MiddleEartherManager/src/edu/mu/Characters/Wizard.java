package edu.mu.Characters;

/**
 * Wizard: A instance of the MiddleEarthCharacter class
 */
public class Wizard extends MiddleEarthCharacter{
	
	/**
	 * Super constructor for Wizard
	 * Sets a Humans attributes
	 * @param name
	 * @param health
	 * @param power
	 */
	public Wizard(String name, double health, double power) {
		super(name, health, power);
	}
	
	/**
	 * Takes a target and determines what a Wizard can attack
	 * @param target
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Wizard || target instanceof Human) {
			return false;
		}
		
		if (target instanceof Dwarf) {
			this.power = 1.5;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns race of MiddleEarthCharacter
	 */
	public String getRace() {
		return "Wizard";
	}
}