package elvinos.java.ExerciseThree;

public class CreditCardTester {

    public static void main(String[] args){
        CreditCard cc1 = new CreditCard(10, 2014, "Bob", "Jones", "1234567890123456");
        CreditCard cc2 = new CreditCard(8, 2018, "Alex", "Charles", "1234567890123456");

        System.out.println(cc1.toString());
        System.out.println(cc2.toString());
    }
}
