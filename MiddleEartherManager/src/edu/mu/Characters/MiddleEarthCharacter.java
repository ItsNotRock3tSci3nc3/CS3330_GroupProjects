package edu.mu.Characters;

public abstract class MiddleEarthCharacter {
	String name;
	double health;
	double power;
	
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getHealth() {
		return health;
	}



	public void setHealth(double health) {
		this.health = health;
	}


	public double getPower() {
		return power;
	}


	public void setPower(double power) {
		this.power = power;
	}



	public abstract boolean attack(MiddleEarthCharacter target);
	
	public abstract String getRace();
	
	public String displayInfo() {
		String info = "Name: " + name + "\nHealth: " + health + "\nPower: " + power;
		//System.out.println(info);
		return info;
	}
}