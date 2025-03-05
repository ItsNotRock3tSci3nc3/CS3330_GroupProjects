package edu.mu.Characters;

/**
 * Dwarf: A instance of the MiddleEarthCharacter class
 */
public class Dwarf extends MiddleEarthCharacter {
	
	/**
	 * Super constructor for Dwarf
	 * Sets a Dwarfs attributes
	 * @param name
	 * @param health
	 * @param power
	 */
	public Dwarf(String name, double health, double power) {
		super(name, health, power);
	}
	
	/**
	 * Takes a target and determines what a Dwarf can attack
	 * @param target
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Dwarf || target instanceof Wizard) {
			return false;
		}
		
		double damage = power;
		
		if (target instanceof Elf) {
			damage = 1.5;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns race of MiddleEarthCharacter
	 */
	public String getRace() {
		return "Dwarf";
	}
}
