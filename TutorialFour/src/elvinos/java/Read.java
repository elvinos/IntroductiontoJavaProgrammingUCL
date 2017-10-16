package elvinos.java;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class Read {


    public  static ArrayList<String> readFile(String fileName){
        // This will reference one line at a time
        String line;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            StringBuffer stringBuffer = new StringBuffer();
            ArrayList<String> text = new ArrayList();

            while((line = bufferedReader.readLine()) != null) {
                text.add(line);
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }

            bufferedReader.close();
            return text;
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "File not found '" +
                            fileName + "'");
            return null;
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            return null;

        }
    }
}