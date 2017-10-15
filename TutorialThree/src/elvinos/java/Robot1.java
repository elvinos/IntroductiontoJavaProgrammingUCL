package elvinos.java;

public class Robot1 {

    private double batteryCharge = 5.0;

    public void batteryReCharge(double c){
        batteryCharge = batteryCharge + c;
        System.out.println("Battery Charge is: " + batteryCharge);
    }

    public void move(int distance) {
        for (int i = 1; i <= distance; i++) {
            if (0.5 <= batteryCharge) {
                batteryCharge = batteryCharge - 0.5;
                System.out.print("[" + i + "] ");
            }
            else {
                System.out.print("Out of Power! \n");
            }
        }
    }

}
