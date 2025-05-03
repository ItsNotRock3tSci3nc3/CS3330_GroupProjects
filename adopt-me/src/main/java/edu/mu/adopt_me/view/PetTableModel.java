package edu.mu.adopt_me.view;

import edu.mu.adopt_me.model.Pet;
import edu.mu.adopt_me.shelter.Shelter;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * TableModel backed by a Shelter<Pet>.
 */
public class PetTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private final String[] columnNames = {
        "ID", "Type", "Species", "Name", "Age", "Adopted"
    };
	
    private List<Pet> pets = new ArrayList<>();

    public PetTableModel(Shelter<Pet> shelter) {
        setShelter(shelter);
    }

    // Refreshes shelter
    public void setShelter(Shelter<Pet> shelter) {
        this.pets = new ArrayList<>(shelter.getAll());
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return pets.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Pet pet = pets.get(row);
        switch (col) {
            case 0: 
            	return pet.getId();
            case 1: 
            	return pet.getType();
            case 2: 
            	return pet.getSpecies();
            case 3: 
            	return pet.getName();
            case 4: 
            	return pet.getAge();
            case 5: 
            	return pet.isAdopted();
            default: 
            	return null;
        }
    }

    // Get pet for a specific row
    public Pet getPetAt(int row) {
        return pets.get(row);
    }
}
