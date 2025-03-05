package edu.mu.Characters;

public class Dwarf extends MiddleEarthCharacter {
	public Dwarf(String name, double health, double power) {
		super(name, health, power);
	}
	
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
	
	public String getRace() {
		return "Dwarf";
	}
}
