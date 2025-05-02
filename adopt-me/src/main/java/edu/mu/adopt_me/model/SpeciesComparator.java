package edu.mu.adopt_me.model;

import java.util.Comparator;

/** Sorts pets by species (alphabetically) */
public class SpeciesComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet a, Pet b) {
        return a.getSpecies().compareToIgnoreCase(b.getSpecies());
    }
}

