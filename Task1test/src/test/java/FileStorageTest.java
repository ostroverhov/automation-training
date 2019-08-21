import exception.FileAlreadyExistsException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class FileStorageTest {

    FileStorage fileStorage;
    String content = "test content";
    String maxContent = "11111111111111111111111111111111111111111111111111111111111111111111111" +
            "11111111111111111111111111111111111111111111111111111111111111111111111" +
            "11111111111111111111111111111111111111111111111111111111111111111111111" +
            "11111111111111111111111111111111111111111111111111111111111111111111111" +
            "11111111111111111111111111111111111111111111111111111111111111111111111";
    String filename = "Test.txt";

    @DataProvider(name = "testFileStorageExistDelete")
    public Object[][] testFileStorageExistDelete() {
        return new Object[][]{
                {filename, filename, true},
                {filename, filename + "x", false}
        };
    }

    @DataProvider(name = "testFileStorageAvailableMaxSize")
    public Object[][] testFileStorageAvailableMaxSize() {
        return new Object[][]{
                {new FileStorage()},
                {new FileStorage(200)}
        };
    }

    @DataProvider(name = "testFileStorageConstructor")
    public Object[][] testFileStorageConstructor() {
        return new Object[][]{
                {new FileStorage(), 100, 100},
                {new FileStorage(200), 200, 200}
        };
    }

    @Test(dataProvider = "testFileStorageConstructor")
    public void testConstructorMaxSize(FileStorage fileStorage, int testAvailableSize, int testMaxSize) throws NoSuchFieldException, IllegalAccessException {
        int maxSize = ReflectionForTest.getMaxSizeFileStorage(fileStorage);
        Assert.assertEquals(maxSize, testMaxSize, "wrong maxSize in constructor fileStorage");
    }

    @Test(dataProvider = "testFileStorageConstructor")
    public void testConstructorAvailableSize(FileStorage fileStorage, int testAvailableSize, int testMaxSize) throws NoSuchFieldException, IllegalAccessException {
        int availableSize = ReflectionForTest.getAvailableSizeFileStorage(fileStorage);
        Assert.assertEquals(availableSize, testAvailableSize, "wrong availableSize in constructor fileStorage");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConstructorCreateWithNegativeSize() {
        new FileStorage(-1);
    }

    @Test
    public void testWrite() throws FileAlreadyExistsException, NoSuchFieldException, IllegalAccessException {
        FileStorage fileStorage = new FileStorage();
        ArrayList<File> files = new ArrayList<>();
        files.add(new File("Test1.txt", content));
        files.add(new File("Test2.txt", content));
        files.add(new File("Test3.txt", content));
        ReflectionForTest.addFilesToFileStorage(fileStorage, files);
        File file = new File(filename, content);
        fileStorage.write(file);

        ArrayList<File> testFiles = ReflectionForTest.getFilesFromFileStorage(fileStorage);
        File testFile = testFiles.get(3);

        String testFileName = ReflectionForTest.getFileName(testFile);
        String testFileContent = ReflectionForTest.getFileContent(testFile);

        Assert.assertEquals(testFileName, filename, "filename incorrect in written file");
        Assert.assertEquals(testFileContent, content, "content incorrect in written file");
    }

    @Test
    public void testWriteDeficientFileStorage() throws FileAlreadyExistsException {
        FileStorage fileStorage = new FileStorage();
        File file = new File(filename, maxContent);
        Assert.assertFalse(fileStorage.write(file));
    }

    @Test(expectedExceptions = FileAlreadyExistsException.class)
    public void testWriteException() throws NoSuchFieldException, IllegalAccessException, FileAlreadyExistsException {
        FileStorage fileStorage = new FileStorage();
        ArrayList<File> files = new ArrayList<>();
        files.add(new File(filename, content));
        ReflectionForTest.addFilesToFileStorage(fileStorage, files);
        fileStorage.write(files.get(0));
    }

    @Test(dataProvider = "testFileStorageExistDelete")
    public void testIsExists(String filename, String filenameToCheck, boolean res) throws NoSuchFieldException, IllegalAccessException {
        FileStorage fileStorage = new FileStorage();
        ArrayList<File> files = new ArrayList<>();
        File file = new File(filename, content);
        files.add(file);
        ReflectionForTest.addFilesToFileStorage(fileStorage, files);
        Assert.assertEquals(fileStorage.isExists(filenameToCheck), res, "method isExist doesn't find file");
    }

    @Test(dataProvider = "testFileStorageExistDelete")
    public void testDelete(String filename, String filenameToDelete, boolean res) throws NoSuchFieldException, IllegalAccessException {
        FileStorage fileStorage = new FileStorage();
        ArrayList<File> files = new ArrayList<>();
        File file = new File(filename, content);
        files.add(file);
        ReflectionForTest.addFilesToFileStorage(fileStorage, files);
        Assert.assertEquals(fileStorage.delete(filenameToDelete), res, "");
    }

    @Test
    public void testSizeAfterDelete() throws NoSuchFieldException, IllegalAccessException {
        FileStorage fileStorage = new FileStorage();
        ArrayList<File> files = new ArrayList<>();
        File file = new File(filename, content);
        files.add(file);
        ReflectionForTest.addFilesToFileStorage(fileStorage, files);
        int sizeBefore = ReflectionForTest.getAvailableSizeFileStorage(fileStorage);
        fileStorage.delete(filename);
        int sizeAfter = ReflectionForTest.getAvailableSizeFileStorage(fileStorage);
        Assert.assertEquals(sizeBefore - (int) ReflectionForTest.getFileSize(file), sizeAfter, "size filestorage doesn't change after delete file");
    }

    @Test
    public void testGetFiles() throws NoSuchFieldException, IllegalAccessException {
        FileStorage fileStorage = new FileStorage();
        ArrayList<File> files = new ArrayList<>();
        files.add(new File("Test1.txt", content));
        files.add(new File("Test2.txt", content));
        files.add(new File("Test3.txt", content));
        ReflectionForTest.addFilesToFileStorage(fileStorage, files);
        ArrayList<File> testFiles;
        testFiles = ReflectionForTest.getFilesFromFileStorage(fileStorage);
        Assert.assertEquals(fileStorage.getFiles(), testFiles, "method getFiles doesn't return file");
    }

    @Test
    public void testGetFile() throws NoSuchFieldException, IllegalAccessException {
        FileStorage fileStorage = new FileStorage();
        ArrayList<File> files = new ArrayList<>();
        File file = new File(filename, content);
        files.add(file);
        ReflectionForTest.addFilesToFileStorage(fileStorage, files);
        Assert.assertEquals(fileStorage.getFile(filename), file, "method getFile return wrong file");
    }

    @Test
    public void testGetFileNotExist() throws NoSuchFieldException, IllegalAccessException {
        FileStorage fileStorage = new FileStorage();
        ArrayList<File> files = new ArrayList<>();
        File file = new File(filename, content);
        files.add(file);
        ReflectionForTest.addFilesToFileStorage(fileStorage, files);
        Assert.assertNull(fileStorage.getFile(filename + "x"), "method getFile doesn't return null when file doesn't exist");
    }

    @Test(dataProvider = "testFileStorageAvailableMaxSize")
    public void testGetAvailableSize(FileStorage fileStorage) throws NoSuchFieldException, IllegalAccessException {
        int testAvailableSize = ReflectionForTest.getAvailableSizeFileStorage(fileStorage);
        Assert.assertEquals(fileStorage.getAvailableSize(), testAvailableSize, "method getAvailableSize return wrong availableSize");
    }

    @Test(dataProvider = "testFileStorageAvailableMaxSize")
    public void testGetMaxSize(FileStorage fileStorage) throws NoSuchFieldException, IllegalAccessException {
        int testMaxSize = ReflectionForTest.getMaxSizeFileStorage(fileStorage);
        Assert.assertEquals(fileStorage.getMaxSize(), testMaxSize, "method getMaxSize return wrong maxSize");
    }
}