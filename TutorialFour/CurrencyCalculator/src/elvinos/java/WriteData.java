package elvinos.java;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.lang.NullPointerException;

class Writer {

    static void WriteData(String userData) throws IOException, NullPointerException {

        try {
            FileWriter writer = new FileWriter("output.txt", true);

            writer.write(userData + "\n");

            writer.close();

        } catch (NullPointerException e) {
            System.out.println("No user input");

        } catch (NoSuchFileException e) {
            FileWriter writer = new FileWriter("output.txt");

            writer.write(userData);

            writer.close();
        }
    }
}
