package framework;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Writer {

    public static void writeCategory(List<String> category, String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        for (String s:category) {
            fileWriter.write(s + "\n");
        }
        fileWriter.close();
    }
}
