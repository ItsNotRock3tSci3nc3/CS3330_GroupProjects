package edu.mu.Characters;

public class Orc extends MiddleEarthCharacter {
	public Orc(String name, double health, double power) {
		super(name, health, power);
	}
	
	
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Orc || target instanceof Elf) {
			return false;
		}
		
		double damage = power;
		
		if (target instanceof Human) {
			damage = 1.5;
			return true;
		}
		
		return false;
	}
	
	public String getRace() {
		return "Orc";
	}
}
