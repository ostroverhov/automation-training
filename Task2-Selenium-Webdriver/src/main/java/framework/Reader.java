package framework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Reader {

    public static String getParametr(String parametr) {
        Properties property = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String parametrFromProperties = property.getProperty(parametr);
        return parametrFromProperties;
    }

    public static List<String> readCategory(String pathToTheFile) throws IOException {
        FileReader fileReader = new FileReader(pathToTheFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> categories = new ArrayList<>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            categories.add(line);
        }
        bufferedReader.close();
        return categories;
    }
}
