package edu.mu.adopt_me.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import edu.mu.adopt_me.model.Pet;

/** 
* MainView represents the GUI for the Pet Adoption Center application.
* It provides components to view, add, remove, adopt, sort, and save pets.
*/
public class MainView extends JFrame {
	private DefaultListModel<Pet> petListModel = new DefaultListModel<>();
	private JList<Pet> petJList = new JList<>(petListModel);
	private JButton addButton = new JButton("Add Pet");
	private JButton removeButton = new JButton("Remove Pet");
	private JButton detailsButton = new JButton("View Details");
	private JButton adoptButton = new JButton("Adopt Pet");
	private	JButton saveButton = new JButton("Save List");
	private	JComboBox<String> sortCombo = new JComboBox<>(new String[]{"Name", "Age", "Species"});


/**
* Constructs the main application window with all UI components.
*/
public MainView() {
	setTitle("Pet Adoption Center");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(600, 400);
	setLocationRelativeTo(null);
	
	JPanel topPanel = new JPanel(new FlowLayout());
	topPanel.add(addButton);
	topPanel.add(removeButton);
	topPanel.add(detailsButton);
	topPanel.add(adoptButton);
	topPanel.add(saveButton);
	topPanel.add(new JLabel("sort by"));
	topPanel.add(sortCombo);
	
    petJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(petJList);

    add(topPanel, BorderLayout.NORTH);
    add(scrollPane, BorderLayout.CENTER);
}

/**
* Updates the pet list displayed in the UI.
* @param pets the list of pets to display
*/
public void updatePetList(List<Pet> pets) {
    petListModel.clear();
    for (Pet pet : pets) {
        petListModel.addElement(pet);
    }
}

/**
* @return the JList component displaying the pets
* @return the button for adding a pet
* @return the button for removing a pet
* @return the button for adopting a pet
* @return the button for saving a pet
* @return the button for saving the pet list
* @return the button for viewing pet details
* @return the combo box used for sorting
*/
public JList<Pet> getPetJList() { return petJList; }
public JButton getAddButton() { return addButton; }
public JButton getRemoveButton { return removeButton; }
public JButton getAdoptButton { return adoptButton; }
public JButton getSaveButton { return saveButton; }
public JButton getDetailsButton { return detailsButton; }
public JComboBox<String> getSortCombo() { return sortCombo; }
