package edu.mu.adopt_me.model;

/**
 * Base class for any adoptable pet.
 */
public abstract class Pet implements Comparable<Pet> {
	private String id;
	private String type; // Dog or cat etc.
	private String species; // Husky, Golden retirver
	private String name;
	private int age;
	private boolean adopted;
	
	/**
	 * @param id -> Unique identifier
	 * @param type -> type of animal
	 * @param species -> specific breed of that animal
	 * @param name -> given name
	 * @param age -> years old
	 */
	public Pet(String id, String type, String species, String name, int age) {
		this.id = id;
		this.type = type;
		this.species = species;
		this.name = name;
		this.age = age;
		this.adopted = false;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getSpecies() {
		return species;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isAdopted() {
		return adopted;
	}

	/**
	 * Adopt pet, throws error if already adopted.
	 */
	public void adopt() {
		if (adopted) {
			throw new IllegalStateException(name + " has already been adopted.");
		}
		adopted = true;
	}
	
	/**
	 * Allow age to be updated with birthday
	 * @param age
	 */
	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age can't be negative.");
		}
		this.age = age;
	}
	
	@Override
	public int compareTo(Pet other) {
		return this.name.compareToIgnoreCase(other.name);
	}
	
	@Override
	public String toString() {
		return String.format("%s [%s]: %s, age %d%s", name, type, species, age, adopted ? " (adopted)" : "");
	}
}
