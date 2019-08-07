import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Task1_1_searchLastChange {
    public static void main(String[] args) {
        String name = "65E1Q1frpqM.jpg";
        File dir = new File("Home/Trash");

        File[] dirList = dir.listFiles();
        File lastModifiedFile = dirList[0];

        for (int i = 0; i < dirList.length; i++) {
            if (dirList[i].getName().contains(name)){
                if (dirList[i].lastModified() >= lastModifiedFile.lastModified()){
                    lastModifiedFile = dirList[i];
                }
            }
        }
        System.out.println(lastModifiedFile.getName());

        for (int i = 0; i < dirList.length; i++) {
            if (dirList[i].lastModified() + 10000 >= lastModifiedFile.lastModified());
            System.out.println(dirList[i]);
        }
    }
}
