package TestFrame;

import javax.swing.*;
import java.awt.*;

public class CapitalsCountries extends JFrame {
    String[] countries = {"Ethiopia", "Turkey", "Greece", "Iraq", "Serbia", "Colombia"};
    String[] capitals = {"Addis Ababa", "Ankara", "Athens", "Baghdad", "Belgrade", "Bogota"};

    private final JLabel label;
    private final JComboBox<String> comboBox = new JComboBox<>(countries);

    public CapitalsCountries() {
        super("Capitals of countries");
        label = new JLabel("");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(100, 50, 100, 30);
        comboBox.setBounds(100, 10, 100, 30);

        comboBox.setSelectedIndex(0);

        comboBox.addActionListener(actionEvent
                -> label.setText(capitals[comboBox.getSelectedIndex()]));

        setLayout(null);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        label.setText(capitals[0]);
        add(comboBox);
        add(label);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CapitalsCountries::new);
    }
}


