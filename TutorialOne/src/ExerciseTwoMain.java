import java.util.Scanner;

public class ExerciseTwoMain {

    private static Scanner input;
	private static Scanner input2;
	private static Scanner input3;

	public static void main(String[] args) {

        int userChoice;
        setInput(new Scanner(System.in));

        userChoice = menuSelectOpp();

        int answer = 0;
        float answerdiv = 0;

        switch (userChoice) {
            case 5:
                // Perform "divide number" case.
                Scanner fact = new Scanner(System.in);
                System.out.println("Please Choose your Factorial number:");
                int n = fact.nextInt();
                answer = factorial(n);
                System.out.println("Answer = " + answer);
                System.exit(0);
                break;
            case 6:
                // Perform "quit" case.
                System.exit(0);
            default:
                // The user input an unexpected choice.
        }

        int[] arguements = menuNumber();
        int a = arguements[0];
        int b = arguements[1];
        switch (userChoice) {
            case 1:
                // Perform "add number" case.
                answer = add(a,b);
                break;
            case 2:
                // Perform "subtract number" case.
                answer = subtract(a,b);
                break;
            case 3:
                // Perform "multiply number" case.
                answer = multiply(a,b);
                break;
            case 4:
                // Perform "divide number" case.
                float aa = arguements[0];
                float bb = arguements[1];
                answerdiv = divide(aa,bb);
                break;
            default:
                // The user input an unexpected choice.
        }
        if (userChoice!= 4) {
            System.out.println("Answer = " + answer);
        } else {
            System.out.println("Answer = " + answerdiv);
        }

    }

    public static int menuSelectOpp() {

        int selection;
        input2 = new Scanner(System.in);

        System.out.println("Simple calculator. Please choose an operation:");
        System.out.println("-------------------------\n");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Factorial");
        System.out.println("6. Exit");

        selection = input2.nextInt();
        return selection;
    }

    public static int[] menuNumber() {

        input3 = new Scanner(System.in);
        System.out.println("Please Choose your first number:");
        int fNum = input3.nextInt();
        System.out.println("Please Choose your second number:");
        int sNum = input3.nextInt();

        int[] output = new int[2];
        output[0]= fNum;
        output[1] = sNum;

        return output;

    }

    public static int add(int a, int b){
        int result = a+b;
        return result;
    }
    public static int subtract(int a, int b){
        int result = a-b;
        return result;
    }
    public static int multiply(int a, int b){
        int result = a*b;
        return result;
    }
    public static float divide(float a, float b){
        float result = a/b;
        return result;
    }

    public static int factorial(int n){
        if (n == 0) {
            return 1;
        }
        else {
            return (n * factorial(n - 1));
        }
    }

	public static Scanner getInput() {
		return input;
	}

	public static void setInput(Scanner input) {
		ExerciseTwoMain.input = input;
	}

}

