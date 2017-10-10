import static java.lang.System.arraycopy;

public class ExerciseTwo {

    public static void main(String[] args){

        String[] arr = {"The ", "quick ", "brown ", "fox ", "jumps ", "over ", "the ", "lazy ", "dog."};
        arr = remElement(arr, 7);
        System.out.println(arr);
    }

    public static String[] remElement(String[] arr, int remEl) {

        return arraycopy(arr,remEl+1,arr,remEl,arr.length-1-remEl);

    }


}
