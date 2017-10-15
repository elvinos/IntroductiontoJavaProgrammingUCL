import java.util.ArrayList;
import java.util.Random;

public class ExerciseThree {

    public static void main(String[] args) {

        ArrayList<Integer> aList = new ArrayList<>(100);

        Random randomGenerator = new Random();
        for (int i = 0; i < 100; ++i) {
            aList.add(randomGenerator.nextInt(100));
        }
        int aListLength = aList.size();
        System.out.println("Random Integer Array: " + aList.toString());
        System.out.println("Array Even Sum: " + evenSum(aList));
        ArrayList<Integer> oddList = oddReArr(aList);
        System.out.println("Array Odd/Even Split: " + oddList.toString());

    }

    public static boolean isEven(int number) {
        return (number % 2 == 0);
    }

    public static int evenSum(ArrayList<Integer> array) {
        int totalEven = 0;
        for (int i = 0; i < 100; ++i) {
            if (isEven(array.get(i))){
                totalEven = totalEven + array.get(i);
            }
        }
        return totalEven;
    }

    public static ArrayList<Integer> oddReArr(ArrayList<Integer> array) {
        ArrayList<Integer> aListOdd = new ArrayList<>(100);
        for (int i = 99; i > 0; i--) {
            if (isEven(array.get(i)) == false){
                aListOdd.add(array.get(i));
                array.remove(i);
            }
        }
        array.addAll(aListOdd);
        return array;
    }



}
