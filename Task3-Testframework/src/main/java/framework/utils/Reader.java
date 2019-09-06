package framework.utils;

import java.io.*;
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

    public static String getNameDownloadFile() {
        MyLogger.info("Получение имени файла в зависимости от ОС");
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            return getParametr("pathToFileWindows");
        } else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            return getParametr("pathToFileLinux");
        } else {
            MyLogger.warn("Не поддерживаемая ОС");
            throw new IllegalArgumentException("Не поддерживаемая ОС");
        }
    }
}