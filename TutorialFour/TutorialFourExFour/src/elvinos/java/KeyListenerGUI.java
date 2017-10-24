package elvinos.java;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerGUI implements KeyListener {
    private static int counter = 0;
    private JPanel keyPanel;
    private JTextField keyInput;
    private JLabel keyLabel;

    Keylistener() {
        void keyPressed (KeyEvent e){
            String inputStr = keyInput.getText();
            keyLabel.setText(inputStr);
            counter++;
            System.out.println(counter);
        }
        ;

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Keylistener");
        frame.setContentPane(new Keylistener().keyPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
