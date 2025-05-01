package edu.mu.adopt_me.model;

/**
 * A dog that can be adopted.
 */
public class Dog extends Pet {
	public Dog(String id, String species, String name, int age) {
		super(id, "Dog", species, name, age);
	}
}
