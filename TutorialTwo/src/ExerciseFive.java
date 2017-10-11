import java.util.ArrayList;
import java.util.Vector;

/**
* Created By Alex Charles 10/10/2017
* Creates Pascal's Triangle
 */


public class ExerciseFive {

    public static void main(String[] args) {

        int numRows = 10;
        int[][] pascalBuilder = new int [numRows][numRows];
        pascalBuilder[0][0]= 1;
        pascalBuilder[1][0]= 1;
        pascalBuilder[1][1]= 1;
        if(numRows < 3){
            return;
        }

        for (int row=2; row < numRows; row++){
//            pascalBuilder[row] = new int[row+1];
            pascalBuilder[row][0] = 1;
            pascalBuilder[row][row] = 1;
            for(int col=1; col<numRows; col++){
                pascalBuilder[row][col] = pascalBuilder[row-1][col-1] +
                        pascalBuilder[row-1][col];
            }
        }

//        print(pascalBuilder);
        printNice(pascalBuilder);

    }

    public static int print(int[][] pascalBuilder) {
        for (int row=0; row<pascalBuilder.length; row++) {
            for (int col=0; col<pascalBuilder[row].length; col++) {
                System.out.print("\t" + pascalBuilder[row][col]);
            }
            System.out.println();
        }
        return 1;
    }

    public static int printNice(int[][] pascalBuilder) {

        for (int row=0; row<pascalBuilder.length; row++) {
            int nonZero = row - pascalBuilder[row].length;
            if (row % 2 == 0){
//                System.out.print("\t");
            }
            for (int col=0; col<pascalBuilder[row].length; col++) {
                if (pascalBuilder[row][col] == 0) {
                    System.out.print("\t");

                } else {
                    System.out.print(Integer.toString(pascalBuilder[row][col]) + "\t");
                }
            }
            System.out.println();
        }
        return 1;
    }

    public static int printNiceArray(int[][] pascalBuilder, int numRows) {
        int[][] prettyPascalBuilder = new int [numRows][numRows];
        for (int row=0; row<pascalBuilder.length; row++) {
            int nonZero = row - pascalBuilder[row].length;
            int spaceBefore = nonZero/2;
            int spaceCount = 0;
            for (int col=0; col<pascalBuilder[row].length; col++) {
                if( col < spaceBefore){
                    spaceCount++;
                }
                if (pascalBuilder[row][col] == 0) {
                    System.out.print("\t");
                    spaceCount++;
                } else {
                    System.out.print(Integer.toString(pascalBuilder[row][col]) + "\t");
                }
            }
            System.out.println();
        }
        return 1;
    }

//    public static void printPascalTriangle(int numRows){
//
//
//
//    }

}