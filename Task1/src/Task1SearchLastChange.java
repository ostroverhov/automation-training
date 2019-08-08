import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Task1SearchLastChange {
    public static void main(String[] args) {
        String name = "doc";
        File dir = new File("/home/ITRANSITION.CORP/v.ostroverhov/Documents");

        File[] dirList = dir.listFiles();
        File lastModifiedFile = dirList[0];

        for (File file : dirList) {
            if (file.getName().startsWith(name)) {
                if (file.lastModified() >= lastModifiedFile.lastModified()) {
                    lastModifiedFile = file;
                }
            }
        }
        for (File file : dirList) {
            if (file.lastModified() + 10000 >= lastModifiedFile.lastModified()) {
                System.out.println(file);
            }
        }
    }
}
