package elvinos.java;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyGUI {

     JPanel panel;
     JTextField inputBox;
     JButton submitButton;
     JLabel resultsLabel;
    private JComboBox selectCur;
    private JComboBox orgCur;
    private JLabel labelVal;
    private JLabel labelOrig;
    private JLabel labelCur;
    private JLabel labelRes;


    CurrencyGUI() {
        submitButton.addActionListener(e -> {
//                JOptionPane.showMessageDialog(null,"Hello World");
            String cNameOrg = (String)orgCur.getSelectedItem();
            String cNameNew = (String)selectCur.getSelectedItem();
            String inputStr = inputBox.getText();
            try {
                Double input = Double.parseDouble(inputStr);
                Double result = convert(input, cNameOrg, cNameNew);
                String resultStr = String.valueOf(result);
                resultsLabel.setText(resultStr);
                try {
                    writeResult(inputStr, cNameOrg, cNameNew, resultStr);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (NumberFormatException g){
                String resultStr = "Invalid Input! Try again...";
                resultsLabel.setText(resultStr);
            }

        });
    }

    public static void main(String[] args){

        JFrame frame = new JFrame("CurrencyGUI");
        frame.setContentPane(new CurrencyGUI().panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static ArrayList<Currency> returnCurrencies(){
        ArrayList<Currency> currencies= new ArrayList<>();

        Currency GBP = new Currency("GBP", 1.0);
        Currency USD = new Currency("USD", 1.32);
        Currency YEN = new Currency("YEN", 148.91);
        Currency EU = new Currency("EU", 1.12);

        currencies.add(GBP);
        currencies.add(USD);
        currencies.add(YEN);
        currencies.add(EU);

        return currencies;
    }

    private void createUIComponents() {
        selectCur = new JComboBox<>();
        for(Currency i : returnCurrencies()) {
            selectCur.addItem(i.name);
        }
        orgCur = new JComboBox<>();
        for(Currency i : returnCurrencies()) {
            orgCur.addItem(i.name);
        }

    }
    private void $$$setupUI$$$() {
        createUIComponents();
    }

    public static Double convert(Double input, String cNameOrg, String cNameNew){
        Double result = null;
        Double inputCov = input;
        for(Currency c : returnCurrencies()) {
            if (c.name.equals(cNameOrg)) {
                Double rateOrg = c.getRate();
                inputCov = input / rateOrg;
            }
        }
        for(Currency c : returnCurrencies()){
            if(c.name.equals(cNameNew)){
                Double rate = c.getRate();
                result = rate*inputCov;
                System.out.println("Input: " + inputCov + " Result " + result);
            }
        }
        return result;
    }

    public void writeResult(String inputStr, String cNameOrg, String cNameNew, String resultStr) throws IOException {

        String outputString = new String(inputStr + cNameOrg + " -> " + resultStr + cNameNew);
        Writer.WriteData(outputString);
    }


}
