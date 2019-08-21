import java.lang.reflect.Field;
import java.util.ArrayList;

public class ReflectionForTest {
    static void addFilesToFileStorage(FileStorage fileStorage, ArrayList<File> files) throws NoSuchFieldException, IllegalAccessException {
        Field field = fileStorage.getClass().getDeclaredField("files");
        field.setAccessible(true);
        field.set(fileStorage, files);
    }

    static ArrayList getFilesFromFileStorage(FileStorage fileStorage) throws NoSuchFieldException, IllegalAccessException {
        Field field = fileStorage.getClass().getDeclaredField("files");
        field.setAccessible(true);
        return (ArrayList<File>) field.get(fileStorage);
    }

    static String getFileName(File file) throws NoSuchFieldException, IllegalAccessException {
        Field field = file.getClass().getDeclaredField("filename");
        field.setAccessible(true);
        return (String) field.get(file);
    }

    static String getFileContent(File file) throws NoSuchFieldException, IllegalAccessException {
        Field field = file.getClass().getDeclaredField("content");
        field.setAccessible(true);
        return (String) field.get(file);
    }

    static double getFileSize(File file) throws NoSuchFieldException, IllegalAccessException {
        Field field = file.getClass().getDeclaredField("size");
        field.setAccessible(true);
        return (double) field.get(file);
    }

    static String getFileExtension(File file) throws NoSuchFieldException, IllegalAccessException {
        Field field = file.getClass().getDeclaredField("extension");
        field.setAccessible(true);
        return (String) field.get(file);
    }

    static int getMaxSizeFileStorage(FileStorage fileStorage) throws NoSuchFieldException, IllegalAccessException {
        Field field = fileStorage.getClass().getDeclaredField("maxSize");
        field.setAccessible(true);
        return field.getInt(fileStorage);
    }

    static int getAvailableSizeFileStorage(FileStorage fileStorage) throws NoSuchFieldException, IllegalAccessException {
        Field field = fileStorage.getClass().getDeclaredField("availableSize");
        field.setAccessible(true);
        return field.getInt(fileStorage);
    }

}
