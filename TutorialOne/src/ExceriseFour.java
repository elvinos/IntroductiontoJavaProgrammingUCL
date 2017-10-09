import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.pow;

public class ExceriseFour {

    private static Scanner bytesScan;

	public static void main(String[] args) {
        final String [ ] UNITS = {"B","KB","MB","GB"};
        bytesScan = new Scanner(System.in);
        System.out.println("What do you want to convert (Number Unit)");
        double numSelec = bytesScan.nextDouble();
        String strSelec = bytesScan.next();
        String strSelecUpper = strSelec.toUpperCase();
//        System.out.println(strSelec);
        double unitInput = 0;

// Check to see if unit has been defined
        if(Arrays.asList(UNITS).contains(strSelecUpper)){
            unitInput = Arrays.asList(UNITS).indexOf(strSelecUpper);
//            System.out.println(unitInput);
        }
        System.out.println("1. Bytes");
        System.out.println("2. KiloBytes");
        System.out.println("3. MegaBytes");
        System.out.println("4. GigaBytes");
        System.out.println("Select Unit Conversion (1-4): ");
        int unitSelc = bytesScan.nextInt();
        double answer = 0;

// Convert Input to BYTES:
        if (unitInput ==  1){
            //KB -> B
            numSelec = numSelec*pow(2,10);
        }
        else if (unitInput ==  2){
            //MB -> B
            numSelec = numSelec*pow(2,20);
        }
        else if (unitInput ==  3){
            //GB -> B
            numSelec = numSelec*pow(2,30);
        }

        switch(unitSelc){
            case 1:
                answer = numSelec;
                break;
            case 2:
                answer = numSelec*pow(2,-10);
                break;
            case 3:
                answer = numSelec*pow(2,-20);
                break;
            case 4:
                answer = numSelec*pow(2,-30);
                break;
            default:
                break;
        }
        System.out.printf("%.0f " + UNITS[unitSelc-1],answer);

    }
}
