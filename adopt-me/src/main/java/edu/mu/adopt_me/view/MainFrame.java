package edu.mu.adopt_me.view;

import com.google.gson.Gson;
import edu.mu.adopt_me.loader.PetLoader;
import edu.mu.adopt_me.model.*;
import edu.mu.adopt_me.shelter.Shelter;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
	private final Shelter<Pet> shelter;
    private final PetTableModel tableModel;
    private final JTable table;
    private final JComboBox<String> sortCombo;
    private final JButton addButton, adoptButton, removeButton, viewButton, saveButton;

    public MainFrame() throws Exception {
        super("Pet Adoption Center");

        // 1) Load data
        shelter = new PetLoader().loadAll();
        tableModel = new PetTableModel(shelter);
        table = new JTable(tableModel);

        // 2) Controls
        sortCombo   = new JComboBox<>(new String[]{"Name", "Age", "Species"});
        addButton   = new JButton("Add");
        adoptButton = new JButton("Adopt");
        removeButton= new JButton("Remove");
        viewButton  = new JButton("View Details");
        saveButton  = new JButton("Save");

        JPanel controls = new JPanel();
        controls.add(new JLabel("Sort by:"));
        controls.add(sortCombo);
        controls.add(addButton);
        controls.add(adoptButton);
        controls.add(removeButton);
        controls.add(viewButton);
        controls.add(saveButton);

        setLayout(new BorderLayout());
        add(controls, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // 3) Listeners

        sortCombo.addActionListener(e -> {
            String sel = (String) sortCombo.getSelectedItem();
            switch (sel) {
                case "Age":     shelter.sort(new AgeComparator());     break;
                case "Species": shelter.sort(new SpeciesComparator()); break;
                default:        shelter.sortByName();                  break;
            }
            tableModel.setShelter(shelter);
        });

        addButton.addActionListener(e -> {
            JTextField idField = new JTextField();
            JComboBox<String> typeBox = new JComboBox<>(new String[]{"Dog", "Cat", "Rabbit"});
            JTextField speciesField = new JTextField();
            JTextField nameField = new JTextField();
            JTextField ageField = new JTextField();

            JPanel panel = new JPanel(new GridLayout(0,2));
            panel.add(new JLabel("ID:"));      panel.add(idField);
            panel.add(new JLabel("Type:"));    panel.add(typeBox);
            panel.add(new JLabel("Breed:"));   panel.add(speciesField);
            panel.add(new JLabel("Name:"));    panel.add(nameField);
            panel.add(new JLabel("Age:"));     panel.add(ageField);

            int res = JOptionPane.showConfirmDialog(this, panel, "Add New Pet",
                                                    JOptionPane.OK_CANCEL_OPTION);
            if (res == JOptionPane.OK_OPTION) {
                try {
                    String id = idField.getText().trim();
                    String type = (String) typeBox.getSelectedItem();
                    String breed = speciesField.getText().trim();
                    String name = nameField.getText().trim();
                    int age = Integer.parseInt(ageField.getText().trim());
                    Pet pet;
                    switch (type) {
                        case "Dog":    pet = new Dog(id, breed, name, age); break;
                        case "Cat":    pet = new Cat(id, breed, name, age); break;
                        case "Rabbit": pet = new Rabbit(id, breed, name, age); break;
                        default: return;
                    }
                    shelter.add(pet);
                    tableModel.setShelter(shelter);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        });

        adoptButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row < 0) return;
            Pet pet = tableModel.getPetAt(row);
            try {
                pet.adopt();
                tableModel.setShelter(shelter);
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        removeButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row < 0) return;
            Pet pet = tableModel.getPetAt(row);
            shelter.remove(pet);
            tableModel.setShelter(shelter);
        });

        viewButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row < 0) return;
            Pet pet = tableModel.getPetAt(row);
            JOptionPane.showMessageDialog(this, pet.toString(), 
                                          "Pet Details", JOptionPane.INFORMATION_MESSAGE);
        });

        saveButton.addActionListener(e -> {
            try {
                String ts = LocalDateTime.now()
                               .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
                String fileName = ts + "_pets.json";
                String json = new Gson().toJson(shelter.getAll());
                try (FileWriter fw = new FileWriter(fileName)) {
                    fw.write(json);
                }
                JOptionPane.showMessageDialog(this, "Saved to " + fileName);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Save failed: " + ex.getMessage());
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainFrame().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
