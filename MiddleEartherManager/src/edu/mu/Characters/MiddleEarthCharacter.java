package edu.mu.Characters;

/**
 * Abstract class MiddleEarthCharacter with attributes:
 * name
 * health
 * power
 */
public abstract class MiddleEarthCharacter {
	String name;
	double health;
	double power;
	
	/**
	 * 
	 * @param name
	 * String
	 * @param health
	 * Double
	 * @param power
	 * Double
	 * Constructor for MiddleEarthCharacter
	 * sets attributes
	 */
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	/**
	 * Getter method for name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for health
	 * @return health
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * Setter method for health
	 * @param health
	 */
	public void setHealth(double health) {
		this.health = health;
	}

	/**
	 * Getter method for power
	 * @return power
	 */
	public double getPower() {
		return power;
	}

	/**
	 * Setter method for power
	 * @param power
	 * double for power value
	 */
	public void setPower(double power) {
		this.power = power;
	}

	/**
	 * Abstract attack method for each instance of MiddleEarthCharacter
	 * @param target
	 * MiddleEarthCharacter object
	 * @return true or false
	 */
	public abstract boolean attack(MiddleEarthCharacter target);
	
	/**
	 * Abstract getRace method for each instance of MiddleEarthCharacter
	 * @return race
	 */
	public abstract String getRace();
	
	/**
	 * Displays character info
	 * @return info
	 */
	public String displayInfo() {
		String info = "Name: " + name + " | Health: " + health + " | Power: " + power;
		return info;
	}
}