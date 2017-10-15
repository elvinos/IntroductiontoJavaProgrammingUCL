package elvinos.java;

public class ExerciseOne {

    public static void main(String[] args) {

        Robot1 r = new Robot1(); // start off with a well-charged battery
        r.move(11);
        r.batteryReCharge(2.5);
        r.batteryReCharge(0.5);
        r.move(5);
    }
}
