package elvinos.java;

import java.util.Random;

public class Robot2 extends Robot1{

    private static String[] sayings;

    public static String[] getSayings() {
        return sayings;
    }

    public static void speak(){
    Random randomGenerator = new Random();

    int rand = randomGenerator.nextInt(sayings.length);
        System.out.println(sayings[rand]);
    }

    public void setSayings(String[] sayings) {
        this.sayings = sayings;
    }
}
