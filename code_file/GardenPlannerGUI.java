// package code_file;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;

public class GardenPlannerGUI extends JFrame {

    private JComboBox<String> plantSelector;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JTextArea searchResultsArea;

    private List<String> flowers = new ArrayList<>();
    private List<String> vegetables = new ArrayList<>();
    private List<String> fruits = new ArrayList<>();

    public GardenPlannerGUI() {
        setTitle("Garden Planner");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout setup
        setLayout(new BorderLayout());

        // Top Panel for Plant Selector
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel selectPlantLabel = new JLabel("Select Plant: ");
        topPanel.add(selectPlantLabel);

        plantSelector = new JComboBox<>(new String[]{"Flower", "Vegetable", "Fruit"});
        topPanel.add(plantSelector);

        add(topPanel, BorderLayout.NORTH);

        // Main Panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel defaultPanel = new JPanel();
        mainPanel.add(defaultPanel, "Default");

        JPanel flowerPanel = createFlowerPanel();
        mainPanel.add(flowerPanel, "Flower");

        JPanel vegetablePanel = createVegetablePanel();
        mainPanel.add(vegetablePanel, "Vegetable");

        JPanel fruitPanel = createFruitPanel();
        mainPanel.add(fruitPanel, "Fruit");

        JPanel searchResultsPanel = createSearchResultsPanel();
        mainPanel.add(searchResultsPanel, "SearchResults");

        add(mainPanel, BorderLayout.CENTER);

        // Bottom Panel for Add and Search buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        bottomPanel.add(addButton);
        bottomPanel.add(searchButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(e -> {
            String selectedPlant = (String) plantSelector.getSelectedItem();
            if ("Flower".equals(selectedPlant)) {
                cardLayout.show(mainPanel, "Flower");
            } else if ("Vegetable".equals(selectedPlant)) {
                cardLayout.show(mainPanel, "Vegetable");
            } else if ("Fruit".equals(selectedPlant)) {
                cardLayout.show(mainPanel, "Fruit");
            }
        });

        searchButton.addActionListener(e -> {
            String selectedPlant = (String) plantSelector.getSelectedItem();
            cardLayout.show(mainPanel, "SearchResults");

            StringBuilder results = new StringBuilder();
            if ("Flower".equals(selectedPlant)) {
                for (String flower : flowers) {
                    results.append(formatFlowerDetails(flower)).append("\n\n");
                }
            } else if ("Vegetable".equals(selectedPlant)) {
                for (String vegetable : vegetables) {
                    results.append(formatVegetableDetails(vegetable)).append("\n\n");
                }
            } else if ("Fruit".equals(selectedPlant)) {
                for (String fruit : fruits) {
                    results.append(formatFruitDetails(fruit)).append("\n\n");
                }
            }
            searchResultsArea.setText(results.toString());
        });
    }

    private JPanel createFlowerPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Enter Flower Name:"), gbc);

        gbc.gridx = 1;
        JTextField flowerNameField = new JTextField(15);
        panel.add(flowerNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Enter Flower Color:"), gbc);

        gbc.gridx = 1;
        JTextField flowerColorField = new JTextField(15);
        panel.add(flowerColorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Smell Intensity:"), gbc);

        gbc.gridx = 1;
        JComboBox<String> intensityComboBox = new JComboBox<>(new String[]{"very strong", "strong", "middle", "weak", "very weak"});
        panel.add(intensityComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Watering Date/Time:"), gbc);

        gbc.gridx = 1;
        JSpinner wateringSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(wateringSpinner, "MM/dd/yyyy HH:mm");
        wateringSpinner.setEditor(timeEditor);
        panel.add(wateringSpinner, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String name = flowerNameField.getText();
            String color = flowerColorField.getText();
            String intensity = (String) intensityComboBox.getSelectedItem();
            Date wateringDate = (Date) wateringSpinner.getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            String flowerDetails = name + ", " + color + ", " + intensity + ", Watering time: " + sdf.format(wateringDate);
            flowers.add(flowerDetails);
            JOptionPane.showMessageDialog(this, "Flower added: " + flowerDetails);
        });

        return panel;
    }

    private JPanel createVegetablePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Enter Vegetable Name:"), gbc);

        gbc.gridx = 1;
        JTextField vegetableNameField = new JTextField(15);
        panel.add(vegetableNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Enter Vegetable Color:"), gbc);

        gbc.gridx = 1;
        JTextField vegetableColorField = new JTextField(15);
        panel.add(vegetableColorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Weight (grams):"), gbc);

        gbc.gridx = 1;
        JTextField weightField = new JTextField(15);
        panel.add(weightField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Watering Date/Time:"), gbc);

        gbc.gridx = 1;
        JSpinner wateringSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(wateringSpinner, "MM/dd/yyyy HH:mm");
        wateringSpinner.setEditor(timeEditor);
        panel.add(wateringSpinner, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String name = vegetableNameField.getText();
            String color = vegetableColorField.getText();
            String weight = weightField.getText();
            Date wateringDate = (Date) wateringSpinner.getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            String vegetableDetails = name + ", " + color + ", " + weight + " grams, Watering time: " + sdf.format(wateringDate);
            vegetables.add(vegetableDetails);
            JOptionPane.showMessageDialog(this, "Vegetable added: " + vegetableDetails);
        });

        return panel;
    }

    private JPanel createFruitPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Enter Fruit Name:"), gbc);

        gbc.gridx = 1;
        JTextField fruitNameField = new JTextField(15);
        panel.add(fruitNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Enter Fruit Color:"), gbc);

        gbc.gridx = 1;
        JTextField fruitColorField = new JTextField(15);
        panel.add(fruitColorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Price ($):"), gbc);

        gbc.gridx = 1;
        JTextField priceField = new JTextField(15);
        panel.add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Watering Date/Time:"), gbc);

        gbc.gridx = 1;
        JSpinner wateringSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(wateringSpinner, "MM/dd/yyyy HH:mm");
        wateringSpinner.setEditor(timeEditor);
        panel.add(wateringSpinner, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String name = fruitNameField.getText();
            String color = fruitColorField.getText();
            String price = priceField.getText();
            Date wateringDate = (Date) wateringSpinner.getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            String fruitDetails = name + ", " + color + ", $" + price + ", Watering time: " + sdf.format(wateringDate);
            fruits.add(fruitDetails);
            JOptionPane.showMessageDialog(this, "Fruit added: " + fruitDetails);
        });

        return panel;
    }

    private JPanel createSearchResultsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        searchResultsArea = new JTextArea();
        searchResultsArea.setEditable(false);
        panel.add(new JScrollPane(searchResultsArea), BorderLayout.CENTER);
        return panel;
    }

    private String formatFlowerDetails(String details) {
        String[] parts = details.split(", ");
        return "Flower Name: " + parts[0] + "\nFlower Color: " + parts[1] + "\nSmell Intensity: " + parts[2] + "\nWatering Time: " + parts[3];
    }

    private String formatVegetableDetails(String details) {
        String[] parts = details.split(", ");
        return "Vegetable Name: " + parts[0] + "\nVegetable Color: " + parts[1] + "\nWeight: " + parts[2] + "\nWatering Time: " + parts[3];
    }

    private String formatFruitDetails(String details) {
        String[] parts = details.split(", ");
        return "Fruit Name: " + parts[0] + "\nFruit Color: " + parts[1] + "\nPrice: " + parts[2] + "\nWatering Time: " + parts[3];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GardenPlannerGUI gui = new GardenPlannerGUI();
            gui.setVisible(true);
        });
    }
}
