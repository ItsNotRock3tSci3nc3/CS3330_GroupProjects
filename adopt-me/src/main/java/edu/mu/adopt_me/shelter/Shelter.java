package edu.mu.adopt_me.shelter;
import edu.mu.adopt_me.model.Pet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * Class for manipulating a shelter.
 * @param <T>
 */
public class Shelter<T extends Pet> {
    private final List<T> pets = new ArrayList<>();

    public void add(T pet) { 
    	pets.add(pet); 
    }
    
    public boolean remove(T pet) { 
    	return pets.remove(pet); 
    }
    
    public Optional<T> findById(String id)   {
        return pets.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    
    public List<T> getAll() { 
    	return Collections.unmodifiableList(pets); 
    }
    
    public void sortByName() { 
    	Collections.sort(pets); 
    }
    
    public void sort(java.util.Comparator<T> cmp) { 
    	pets.sort(cmp); 
    }
}

