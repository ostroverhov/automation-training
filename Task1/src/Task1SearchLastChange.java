import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Task1SearchLastChange {
    public static void main(String[] args) {
        String name = "doc";
        String path = "Task1/src/";
        File dir = new File(path);
        File[] dirList = dir.listFiles();
        if (dirList[0]!=null) {
            ArrayList<File> rightFiles = new ArrayList<>();
            for (File file : dirList) {
                if (file.getName().startsWith(name)) {
                    rightFiles.add(file);
                }
            }

            File lastModifiedFile = rightFiles.get(0);
            int time = 10000;
            for (File file : rightFiles) {
                if (file.lastModified() + time >= lastModifiedFile.lastModified()) {
                    System.out.println(file);
                }
            }
        }
    }
}
