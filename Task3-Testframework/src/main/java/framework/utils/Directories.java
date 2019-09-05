package framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Directories {
    public static void cleanDirectory(String path) {
        for (File file: new File(path).listFiles())
            if (file.isFile()) file.delete();
    }
}
