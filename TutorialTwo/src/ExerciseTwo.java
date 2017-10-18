import java.util.Arrays;

import static java.lang.System.arraycopy;

public class ExerciseTwo {

    public static void main(String[] args){

        String[] arr = {"The ", "quick ", "brown ", "fox ", "jumps ", "over ", "the ", "lazy ", "dog."};
        arr = remElement(arr, 7);
        System.out.println(Arrays.toString(arr));
//        System.out.println(arr);
    }

    public static String[] remElement(String[] arr, int remEl) {
        String[] tempArrray = new String[arr.length-1];
        arraycopy(arr,0 ,tempArrray,0,remEl);
        arraycopy(arr,remEl +1 ,tempArrray,remEl,arr.length-1-remEl);
    return tempArrray;
    }


}
