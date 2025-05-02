package edu.mu.adopt_me.loader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.mu.adopt_me.adapter.ExoticAnimalAdapter;
import edu.mu.adopt_me.model.*;
import edu.mu.adopt_me.shelter.Shelter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Loads pets.json and exotic_animals.json into a Shelter.
 */
public class PetLoader {
    private static final String PETS_FILE   = "pets.json";
    private static final String EXOTIC_FILE = "exotic_animals.json";

    private final Gson gson = new Gson();

    public Shelter<Pet> loadAll() throws Exception {
        Shelter<Pet> shelter = new Shelter<>();
        loadRegularPets(shelter);
        loadExoticPets  (shelter);
        return shelter;
    }

    private void loadRegularPets(Shelter<Pet> shelter) throws Exception {
        try (
            InputStream is = getClass().getClassLoader().getResourceAsStream(PETS_FILE);
            Reader reader = new InputStreamReader(is)
        ) {
            Type listType = new TypeToken<List<PetJson>>(){}.getType();
            List<PetJson> list = gson.fromJson(reader, listType);

            for (PetJson pj : list) {
                Pet pet;
                switch (pj.type.toLowerCase()) {
                    case "dog":
                        pet = new Dog(pj.id, pj.breed, pj.name, pj.age);
                        break;
                    case "cat":
                        pet = new Cat(pj.id, pj.breed, pj.name, pj.age);
                        break;
                    case "rabbit":
                        pet = new Rabbit(pj.id, pj.breed, pj.name, pj.age);
                        break;
                    default:
                        continue;
                }
                shelter.add(pet);
            }
        }
    }

    private void loadExoticPets(Shelter<Pet> shelter) throws Exception {
        try (
            InputStream is = getClass().getClassLoader().getResourceAsStream(EXOTIC_FILE);
            Reader reader = new InputStreamReader(is)
        ) {
            Type listType = new TypeToken<List<ExoticAnimal>>(){}.getType();
            List<ExoticAnimal> list = gson.fromJson(reader, listType);

            for (ExoticAnimal ea : list) {
                shelter.add(new ExoticAnimalAdapter(ea));
            }
        }
    }

    /**
     * Match pets.json and adjust.
     */
    private static class PetJson {
        String id;
        String type;
        String breed;
        String name;
        int age;
    }
}
