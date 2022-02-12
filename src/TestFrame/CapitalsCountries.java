package TestFrame;

import javax.swing.*;
import java.awt.*;

public class CapitalsCountries {
    String[] countries = {"Ethiopia", "Turkey", "Greece", "Iraq", "Serbia", "Colombia"};
    String[] capitals = {"Addis Ababa", "Ankara",  "Athens",  "Baghdad", "Belgrade", "Bogota"};

    private final JLabel label;
    private final JComboBox<String> comboBox = new JComboBox<>(countries);

    public CapitalsCountries() {
        label = new JLabel("");
        label.setHorizontalAlignment(JLabel.CENTER);
        //comboBox = new JComboBox(country);
        comboBox.setSelectedIndex(0);

        comboBox.addActionListener(actionEvent
                -> label.setText(capitals[comboBox.getSelectedIndex()]));

        JFrame frame = new JFrame("Capitals of countries");
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setText(capitals[0]);
        frame.add(comboBox);
        frame.add(label);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CapitalsCountries::new);
    }
}


