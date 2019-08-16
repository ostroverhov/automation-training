import exception.FileAlreadyExistsException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class FileStorageTest {

    FileStorage fileStorage;
    FileStorage smallFileStorage;
    ArrayList<File> testFiles;
    String content = "test content";

    @BeforeMethod
    public void SetUp() throws NoSuchFieldException, IllegalAccessException {
        FileStorage fs = new FileStorage();
        FileStorage smallFS = new FileStorage(-90);
        ArrayList<File> tFiles = new ArrayList<>();

        tFiles.add(new File("Test1.txt", content));
        tFiles.add(new File("Test2.txt", content));
        tFiles.add(new File("Test3.txt", content));

        Field field = fs.getClass().getDeclaredField("files");
        field.setAccessible(true);
        field.set(fs, tFiles);
        field.set(smallFS, tFiles);

        fileStorage = fs;
        smallFileStorage = smallFS;
        testFiles = tFiles;
    }

    @DataProvider(name = "testFileProviderWriteSmallFileStorage")
    public Object[][] testFileProviderWrite() {
        return new Object[][]{
                {fileStorage, new File("Test4.txt", content), true},
                {smallFileStorage, new File("Test4.txt", content), false}
        };
    }

    @DataProvider(name = "testFileStorageExistDelete")
    public Object[][] testFileStorageExistDelete() {
        return new Object[][]{
                {"Test1.txt", true},
                {"Test4.txt", false}
        };
    }

    @DataProvider(name = "testFileStorageConstructorAvailableMaxSize")
    public Object[][] testFileStorageConstructorAvailableMaxSize() {
        return new Object[][]{
                {new FileStorage()},
                {new FileStorage(200)}
        };
    }

    @Test(dataProvider = "testFileStorageConstructorAvailableMaxSize")
    public void testConstructor(FileStorage fileStorage) {
        Assert.assertNotNull(fileStorage);
    }

    @Test
    public void testConstructorCreate() {
        Assert.assertNull(new FileStorage(-1));
    }

    @Test
    public void testConstructorException() {
        try {
            new FileStorage(-1);
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void testWrite() throws FileAlreadyExistsException {
        File file = new File("Test4.txt", content);
        fileStorage.write(file);
        ArrayList<File> testFiles = new ArrayList<>();
        File testFile = null;
        try {
            Field field = fileStorage.getClass().getDeclaredField("files");
            field.setAccessible(true);
            testFiles = (ArrayList<File>) field.get(fileStorage);
            testFile = testFiles.get(3);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(testFile, file);
    }

    @Test(dataProvider = "testFileProviderWriteSmallFileStorage")
    public void testWriteSmallFileStorage(FileStorage fileStorage, File file, Object res) throws FileAlreadyExistsException {
        Assert.assertEquals(fileStorage.write(file), res);
    }

    @Test
    public void testWriteException() {
        try {
            fileStorage.write(testFiles.get(0));
            Assert.fail("Expected FileAlreadyExistsException");
        } catch (FileAlreadyExistsException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test(dataProvider = "testFileStorageExistDelete")
    public void testIsExists(String filename, boolean res) {
        Assert.assertEquals(fileStorage.isExists(filename), res);
    }

    @Test(dataProvider = "testFileStorageExistDelete")
    public void testDelete(String filename, boolean res) {
        Assert.assertEquals(fileStorage.delete(filename), res);
    }

    @Test
    public void testGetFiles() {
        Assert.assertEquals(fileStorage.getFiles(), testFiles);
    }

    @Test
    public void testGetFile() throws NoSuchFieldException, IllegalAccessException {
        String filename = "Test.txt";
        FileStorage fs = new FileStorage();
        ArrayList<File> tFiles = new ArrayList<>();
        File file = new File(filename, content);
        tFiles.add(file);

        Field field = fs.getClass().getDeclaredField("files");
        field.setAccessible(true);
        field.set(fs, tFiles);

        Assert.assertEquals(fs.getFile(filename), file);
        tFiles.remove(file);
        Assert.assertNull(fs.getFile(filename));
    }

    @Test(dataProvider = "testFileStorageConstructorAvailableMaxSize")
    public void testGetAvailableSize(FileStorage fileStorage) {
        int testAvailableSize = 0;
        try {
            Field field = fileStorage.getClass().getDeclaredField("availableSize");
            field.setAccessible(true);
            testAvailableSize = field.getInt(fileStorage);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(fileStorage.getAvailableSize(), testAvailableSize);
    }

    @Test
    public void testGetAvailableException() {
        try {
            FileStorage fileStorage = new FileStorage(-101);
            fileStorage.getAvailableSize();
            System.out.println(fileStorage.getAvailableSize());
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test(dataProvider = "testFileStorageConstructorAvailableMaxSize")
    public void testGetMaxSize(FileStorage fileStorage) {
        int testMaxSize = 0;
        try {
            Field field = fileStorage.getClass().getDeclaredField("maxSize");
            field.setAccessible(true);
            testMaxSize = field.getInt(fileStorage);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(fileStorage.getMaxSize(), testMaxSize);
    }

    @Test
    public void testGetMaxSizeException() {
        try {
            FileStorage fileStorage = new FileStorage(-1);
            fileStorage.getMaxSize();
            Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test(dataProvider = "testFileStorageConstructorAvailableMaxSize")
    public void testCompareAvailableMaxSize(FileStorage fileStorage) {
        int testMaxSize = 0;
        int testAvailableSize = 0;
        boolean res = true;
        try {
            Field fieldMax = fileStorage.getClass().getDeclaredField("maxSize");
            fieldMax.setAccessible(true);
            testMaxSize = fieldMax.getInt(fileStorage);
            Field fieldAvailable = fileStorage.getClass().getDeclaredField("availableSize");
            fieldAvailable.setAccessible(true);
            testAvailableSize = fieldAvailable.getInt(fileStorage);
            if (testAvailableSize > testMaxSize)
                res = false;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(res);
    }
}