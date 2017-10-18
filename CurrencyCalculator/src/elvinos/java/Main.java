package elvinos.java;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");

        ArrayList<Currency> currencies= new ArrayList<>();

        Currency GBP = new Currency("GBP", 1.0);
        Currency USD = new Currency("USD", 1.32);
        Currency YEN = new Currency("YEN", 148.91);
        Currency EU = new Currency("EU", 1.12);

        currencies.add(GBP);
        currencies.add(USD);
        currencies.add(YEN);
        currencies.add(EU);

    }
}
