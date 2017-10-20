package elvinos.java;

import javax.swing.*;
import java.io.IOException;

public class Keylistener {
    private JPanel keyPanel;
    private JTextField keyInput;
    private JLabel keyLabel;

    Keylistener() {
        keyInput.addActionListener(e -> {
            String inputStr = keyInput.getText();
            keyLabel.setText(inputStr);
//
        });
    }

    public static void main(String[] args){

        JFrame frame = new JFrame("Keylistener");
        frame.setContentPane(new Keylistener().keyPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
