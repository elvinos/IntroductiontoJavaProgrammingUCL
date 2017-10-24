package elvinos.java;

import javax.swing.*;
import java.util.ArrayList;

public class ItemlistenerGUI {
    private JComboBox comboOne;
    private JPanel itemPanel;

    ItemlistenerGUI() {
        comboOne.addItemListener(e -> {
            String selectedItem = (String)comboOne.getSelectedItem();
            JOptionPane.showMessageDialog(null,selectedItem);
        });
    }

    public static void main(String[] args){

        JFrame frame = new JFrame("ItemlistenerGUI");
        frame.setContentPane(new ItemlistenerGUI().itemPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    private void $$$setupUI$$$() {
        createUIComponents();
    }

    private void createUIComponents() {
        comboOne = new JComboBox<>();
        String[] items = {"Hello","Test","Awesome"};
        for(String i : items) {
            comboOne.addItem(i);
        }
    }
}
