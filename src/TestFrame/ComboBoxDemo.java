package TestFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxDemo extends JFrame {
    String[] dogs = {"Corgi", "Dog", "Hound", "Lapdog"};

    private final JLabel picture;
    private final JComboBox<String> comboBox;
    private final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(dogs);

    public ComboBoxDemo() {
        super("Parade dogs");
        comboBox = new JComboBox<>(model);
        comboBox.setSelectedIndex(0);
        // Connecting a listener
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //When a new element is selected, the label handler is called
                updateLabel(dogs[comboBox.getSelectedIndex()]);
            }
        });

        //Set up the picture.
        picture = new JLabel();
        updateLabel(dogs[comboBox.getSelectedIndex()]);
        setLayout(new FlowLayout());
        setSize(310, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(comboBox);
        add(picture);
        setVisible(true);
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

