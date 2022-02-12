package TestFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxDemo {
    String[] dogs = {"Corgi", "Dog", "Hound", "Lapdog"};

    private final JLabel picture;
    private final JComboBox<String> comboBox;

    public ComboBoxDemo() {
        comboBox = new JComboBox<>(dogs);
        comboBox.setSelectedIndex(1);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                updateLabel(dogs[comboBox.getSelectedIndex()]);
                System.out.println("User has selected an item " +
                                   "from the combo box.");
            }
        });

        //Set up the picture.
        picture = new JLabel();
        updateLabel(dogs[comboBox.getSelectedIndex()]);
        JFrame frame = new JFrame("Parade dogs");
        frame.setLayout(new FlowLayout());
        frame.setSize(290, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(comboBox);
        frame.add(picture);
        frame.setVisible(true);
    }

    protected void updateLabel(String name) {
        ImageIcon icon = createImageIcon(name + ".png");
        picture.setIcon(icon);
        picture.setToolTipText("A drawing of a " + name.toLowerCase());
        if (icon != null) {
            picture.setText(null);
        } else {
            picture.setText("Image not found");
        }
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        String imgURL = ComboBoxDemo.class.getClassLoader().getResource(path).getPath();
      if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxDemo();
            }
        });
    }
}

