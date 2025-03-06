package edu.mu.Characters;

/**
 * Elf: A instance of the MiddleEarthCharacter class
 */
public class Elf extends MiddleEarthCharacter {
	
	/**
	 * Super constructor for Elf
	 * Sets a Elfs attributes
	 * @param name
	 * @param health
	 * @param power
	 */
	public Elf(String name, double health, double power) {
		super(name, health, power);
	}
	
	/**
	 * Takes a target and determines what a Elf can attack
	 * @param target
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Elf || target instanceof Dwarf) {
			return false;
		}
		
		if (target instanceof Orc) {
			this.power *= 1.5;
			target.health-=this.power;
			return true;
		}
		target.health-=this.power;
		return false;
	}
	
	/**
	 * Returns race of MiddleEarthCharacter
	 */
	public String getRace() {
		return "Elf";
	}
}