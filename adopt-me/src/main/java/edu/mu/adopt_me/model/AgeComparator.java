package edu.mu.adopt_me.model;

import java.util.Comparator;

/** Sorts pets by age ascending */
public class AgeComparator implements Comparator<Pet> {
    @Override
    public int compare(Pet a, Pet b) {
        return Integer.compare(a.getAge(), b.getAge());
    }
}

