package edu.mu.Characters;

public class Wizard extends MiddleEarthCharacter{
	public Wizard(String name, double health, double power) {
		super(name, health, power);
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Wizard || target instanceof Human) {
			return false;
		}
		
		double damage = power;
		
		if (target instanceof Dwarf) {
			damage = 1.5;
			return true;
		}
		
		return false;
	}
	
	public String getRace() {
		return "Wizard";
	}
}
