import java.util.Scanner;

/**
 * Created By Alex Charles 10/10/2017
 * Creates Pascal's Triangle
 */

public class ExerciseFive {

    public static void main(String[] args) {
        while (true) {
            Scanner numRowsScan = new Scanner(System.in);
            System.out.println("How many rows?");
            int numRows = numRowsScan.nextInt();

            int[][] pascalBuilder = pascalBuild(numRows);

            printNiceArray(pascalBuilder, numRows);
            if (numRowsScan.nextLine().equals("quit")) {
                break;
            }
        }
    }

    public static int[][] pascalBuild(int numRows) {
        int[][] pascalBuilder = new int[numRows][numRows];
        pascalBuilder[0][0] = 1;
        if (numRows < 2) {
            return pascalBuilder;
        }
        pascalBuilder[1][0] = 1;
        pascalBuilder[1][1] = 1;
        if (numRows < 3) {
            return pascalBuilder;
        }

        for (int row = 2; row < numRows; row++) {
            pascalBuilder[row][0] = 1;
            pascalBuilder[row][row] = 1;
            for (int col = 1; col < numRows; col++) {
                pascalBuilder[row][col] = pascalBuilder[row - 1][col - 1] +
                        pascalBuilder[row - 1][col];
            }
        }
        return pascalBuilder;
    }

    public static void printNiceArray(int[][] pascalBuilder, int numRows) {
        String[][] prettyPascalBuilder = new String[numRows][numRows];
        String spacer;
        if (numRows < 6) {
            spacer = " ";
        } else if (numRows < 8) {
            spacer = "  ";
        } else if (numRows < 15) {
            spacer = "\t";
        } else {
            spacer = "\t\t";
        }

        for (int row = 0; row < pascalBuilder.length; row++) {
            int Zeros = pascalBuilder[row].length - row - 1;
            int nonZeros = row + 1;
            int spaceBefore = Zeros / 2;
            int numCount = 0;
            if (numRows % 2 == 0) {
                if (row % 2 == 0) {
                    System.out.print(spacer);
                }
            } else {
                if (row % 2 != 0) {
                    System.out.print(spacer);
                }
            }
            for (int col = 0; col < pascalBuilder[row].length; col++) {

                if (col < spaceBefore) {
                    prettyPascalBuilder[row][col] = String.valueOf(0);
                } else if (col < spaceBefore + nonZeros) {
                    prettyPascalBuilder[row][col] = String.valueOf(pascalBuilder[row][numCount]);
                    numCount++;
                } else {
                    prettyPascalBuilder[row][col] = String.valueOf(0);
                }
                if (prettyPascalBuilder[row][col].equals("0")) {
                    System.out.print(spacer + spacer);
                } else {
                    if (7 < numRows) {
                        System.out.print(spacer);
                    }
                    System.out.print(prettyPascalBuilder[row][col] + spacer);
//                    int digits = (int)(Math.log10(pascalBuilder[row][col]));
//                    if (digits > 1){
//                    for(int i = 0; i <= digits; i++) {
//                        System.out.print("\b");
//                    }
//                    }
                }
            }
            System.out.println();
        }
    }

    public static void print(int[][] pascalBuilder) {
        for (int row = 0; row < pascalBuilder.length; row++) {
            for (int col = 0; col < pascalBuilder[row].length; col++) {
                System.out.print("\t" + pascalBuilder[row][col]);
            }
            System.out.println();
        }
    }

}