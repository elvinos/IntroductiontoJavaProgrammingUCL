/*
Pascal Triangle as Object
*/

public class PascalAsObject {
    int builder[][];
    public PascalAsObject (int levels){
        builder = new int[levels][];
        for (int row=0; row<levels; row++) {
            builder[row] = new int[row+1];
            builder[row][0] = 1;
            builder[row][row] = 1;
            for (int col=1; col<row; col++) {
                builder[row][col] = builder[row-1][col-1]+
                        builder[row-1][col];
            }
        }
    }

    public int print() {
        for (int row=0; row<builder.length; row++) {
            for (int col=0; col<builder[row].length; col++) {
                System.out.print(" " + builder[row][col]);
            }
            System.out.println();
        }
        return 1;
    }

    public int prettyPrint() {
        int colwidth = 6;
        for (int row=0; row<builder.length; row++) {
            for (int charcol=0; charcol<(builder.length-row)*(colwidth/2);
                 charcol++) {
                System.out.print(" ");
            }
            for (int col=0; col<builder[row].length; col++) {
                System.out.print(expandTo(builder[row][col],6));
            }
            System.out.println();
        }
        return 1;
    }

    public static String expandTo(int val, int cols) {
        StringBuffer wip = new StringBuffer(Integer.toString(val));
        while (wip.length() < cols) wip.insert(0," ");
        return wip.toString();
    }


    public static void main (String [] args) {
        PascalAsObject pt = new PascalAsObject(10);
        pt.prettyPrint();

    }

}
