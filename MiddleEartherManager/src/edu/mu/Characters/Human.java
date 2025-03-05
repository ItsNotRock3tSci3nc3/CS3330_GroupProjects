package edu.mu.Characters;

public class Human extends MiddleEarthCharacter{
	public Human(String name, double health, double power) {
		super(name, health, power);
	}
	
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		if (target instanceof Human || target instanceof Orc) {
			return false;
		}
		
		double damage = power;
		
		if (target instanceof Wizard) {
			damage = 1.5;
			return true;
		}
		
		return false;
	}
	
	public String getRace() {
		return "Human";
	}
}
