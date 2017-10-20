package elvinos.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Write {

    static void writeFile(String fileName, ArrayList<String[]> userData) throws IOException {
        FileWriter writer = new FileWriter(fileName);


        for (String[] i : userData) {
            writer.write(Arrays.toString(i));
        }

        writer.close();
    }
}
