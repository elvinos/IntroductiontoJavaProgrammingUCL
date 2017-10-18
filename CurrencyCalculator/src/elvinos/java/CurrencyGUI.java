package elvinos.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyGUI {

    private JPanel panel;
    private JTextField inputBox;
    private JComboBox selectCurrency;
    private JTextArea resultsBox;
    private JButton submitButton;
    private JButton claudBut;

    CurrencyGUI(){


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Hello World");

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("CurrencyGUI");
        frame.setContentPane(new CurrencyGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
//        CurrencyGUI cg = new CurrencyGUI();
//        cg.setSize(200,200);
//        cg.setVisible(true);
    }


}
