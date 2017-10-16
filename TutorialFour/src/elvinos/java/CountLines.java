package elvinos.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountLines {
    public static void main(String[] args)throws IOException {
        Scanner input = new Scanner(System.in);
        String files;
//        String fileName = "file2.txt";
//        String[] list = {"Hello", "Goodbye, does this work?"};
//        ArrayList<String[]> userData = new ArrayList();
//        userData.add(list);
//        Write.writeFile(fileName, userData);
        ArrayList<String> readString = new ArrayList();
        ArrayList<String> curFile;
        StringBuilder outputString =new StringBuilder();

        do {
    System.out.print("CountLines on files: ");
    files = input.nextLine();
    String[] filesList = files.split(" ");
    Read reader = new Read();


    for (int i = 0; i < filesList.length; i++) {
        curFile = reader.readFile(filesList[i]);
        String fileName = filesList[i];
        int lines = curFile.size();
        readString.addAll(curFile);
        outputString.append("Name: " + fileName + "\nLines: " + Integer.toString(lines) + "\n");
    }
            outputString.append("Total Number of Lines: " + Integer.toString(readString.size()));
            System.out.println(outputString);

}while (files != "quit");
    }
}
