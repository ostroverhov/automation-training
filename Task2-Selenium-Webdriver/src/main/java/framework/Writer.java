package framework;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Writer {
    List<String> category = new ArrayList<String>();

    public static void writeCategoryCSV(List<String> category) throws IOException {
        FileWriter fileWriter = new FileWriter("category.csv");
        for (String s:category) {
            fileWriter.write(s + "\n");
        }
        fileWriter.close();
    }

}
