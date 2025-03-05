package edu.mu.Characters;

public class Elf extends MiddleEarthCharacter {
	public Elf(String name, double health, double power) {
		super(name, health, power);
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Elf || target instanceof Dwarf) {
			return false;
		}
		
		double damage = power;
		
		if (target instanceof Orc) {
			damage = 1.5;
			return true;
		}
		
		return false;
	}
	
	public String getRace() {
		return "Elf";
	}
}
