package edu.mu.Characters;

/**
 * Orc: A instance of the MiddleEarthCharacter class
 */
public class Orc extends MiddleEarthCharacter {
	
	
	/**
	 * Super constructor for Orc
	 * Sets a Orcs attributes
	 * @param name
	 * @param health
	 * @param power
	 */
	public Orc(String name, double health, double power) {
		super(name, health, power);
	}
	
	/**
	 * Takes a target and determines what a Orc can attack
	 * @param target
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Orc || target instanceof Elf) {
			return false;
		}
		
		if (target instanceof Human) {
			this.power = 1.5;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns race of MiddleEarthCharacter
	 */
	public String getRace() {
		return "Orc";
	}
}
