package elvinos.java;

import javax.swing.*;
import java.util.ArrayList;

public class CurrencyGUI {

     JPanel panel;
     JTextField inputBox;
     JButton submitButton;
     JLabel resultsLabel;
    private JComboBox selectCur;


    CurrencyGUI(){
//        submitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                JOptionPane.showMessageDialog(null,"Hello World");
//                Double input = 120.0;
//                System.out.println(convert(input, "GBP"));
//
//            }
//        });
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

    }
    private void $$$setupUI$$$() {
        createUIComponents();
    }

    public Double convert(Double input, String cName){
        Double result = null;
        for(Currency c : returnCurrencies()){
            if(c.name.equals(cName)){
                Double rate = c.getRate();
                result = rate*input;
                System.out.println(result);
            }
        }
        return result;
    }

}
