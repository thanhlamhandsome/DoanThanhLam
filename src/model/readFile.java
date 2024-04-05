package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFile {
    static String text = "";

    public String readFile() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    text = text + line + "\n";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return text;
    }
}
