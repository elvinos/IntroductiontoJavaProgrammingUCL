import java.util.Scanner;

public class ExerciseOne {

    private static Scanner userIntScan;

    public static void main(String[] args) {

        userIntScan = new Scanner(System.in);
        System.out.println("Input and integer to test even/odd");
        String userIntS = userIntScan.nextLine();
        int userInt = Integer.parseInt(userIntS);
        boolean evenTest = isEven(userInt);
        if (evenTest) {
            System.out.println("Number is Even ");
        } else System.out.println("Number is Odd ");
    }

    /**
     * Returns true if given integer is even, false otherwise * @param number
     *
     * @return
     */
    public static boolean isEven(int number) {
        return (number % 2 == 0);
    }
}
