package edu.mu.adopt_me.adapter;
import edu.mu.adopt_me.model.ExoticAnimal;
import edu.mu.adopt_me.model.Pet;


/**
 * Adapts a Exotic animal to our Pet API.
 */
public class ExoticAnimalAdapter extends Pet {
	private ExoticAnimal exotic;
	
	public ExoticAnimalAdapter(ExoticAnimal exotic) {
		super(exotic.uniqueId, "Exotic", exotic.subSpecies, exotic.animalName, exotic.yearsOld);
		this.exotic = exotic;
	}
	
	/**
	 * Get orinal object.
	 * @return
	 */
	public ExoticAnimal getExoticAnimal() {
		return exotic;
	}
}
