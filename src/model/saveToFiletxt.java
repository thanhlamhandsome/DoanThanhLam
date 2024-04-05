package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class saveToFiletxt {
    public void file(String data) {
        try {
            FileWriter fileWriter = new FileWriter("data.txt", true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
