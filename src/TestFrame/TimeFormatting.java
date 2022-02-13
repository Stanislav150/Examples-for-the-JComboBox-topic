package TestFrame;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeFormatting {

    String[] patterns = {
            "dd.MM.yyyy HH:mm:ss",
            "dd.MM.yyyy, EEEE, HH:mm:ss",
            "yyyy MMMMM dd GGG hh:mm:ss aaa",
    };
    private final JLabel label;
    private final JComboBox<String> comboBox;
    private String formattingStr = patterns[0];
    private int selectedIndex;
    private final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(patterns);

    TimeFormatting() {
        label = new JLabel("00:00:00");
        label.setHorizontalAlignment(JLabel.CENTER);
        comboBox = new JComboBox<>(model);
        //Making the combobox editable
        comboBox.setEditable(true);
        comboBox.addActionListener(actionEvent -> {
            // We get the command that the combobox generates
            String command = actionEvent.getActionCommand();
            // Detect whether the action command is "comboBoxEdited"
            // or "comboBoxChanged"
            if ("comboBoxEdited".equals(command)) {
                selectedIndex = comboBox.getSelectedIndex();
                // If the item has been changed
                if(selectedIndex == -1) {
                    //Getting the value of the changed element
                    Object newValue = comboBox.getSelectedItem();
                    //Add a new item to the list and set the focus on it
                    comboBox.addItem((String) newValue);
                    comboBox.setSelectedItem(newValue);
                }
            } else if ("comboBoxChanged".equals(command)) {
                // Getting the selected element
                Object selected = comboBox.getSelectedItem();
                //Convert the selected element into a string that
                //will be used to format the date and time.
                formattingStr = (String) selected;
            }
        });
        // Example of connecting a listener to a timer (java.swing.Timer)
        Timer timer = new Timer(1000, actionEvent
                -> label.setText(new SimpleDateFormat(formattingStr, Locale.US).format(new Date())));

        JFrame frame = new JFrame("Current date and time");
        frame.setLayout(new FlowLayout());
        frame.setSize(270, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(comboBox);
        frame.add(label);
        timer.start();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TimeFormatting::new);
    }
}
