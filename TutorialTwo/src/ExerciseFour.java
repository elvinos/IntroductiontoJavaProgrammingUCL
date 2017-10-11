/**
* Created By Alex Charles 10/10/2017
* Sorts Array with Real Positive Integers
 */


//import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class ExerciseFour {

    private static Scanner userFloatArrayScan;

    public static void main(String[] args) {

        /*
        * Takes user input of list of real positive numbers separated by spaces
         */
        userFloatArrayScan = new Scanner(System.in);
        System.out.println("Input list of positive real numbers");
        String userInput = userFloatArrayScan.nextLine();

        /*
        * Splits user input into a String Array
         */
        String[] stringList = userInput.split(" ");
//        System.out.println(Arrays.toString(stringList));

        /*
        * Creates Vector Float Array
        * Float is used to take all real numbers
         */
        Vector<Float> floatArray = new Vector<>(50);
        for (String i : stringList){
            floatArray.add(Float.valueOf(i));
        }
        /*
        * Uses Java sort method to arrange chronologically
         */
        Collections.sort(floatArray);
        for (Float i : floatArray){
            System.out.print(i + " ");
        }

    }

}