import exception.FileAlreadyExistsException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

public class FileTest {
    String content = "test content";
    String filename = "test.txt";

    @DataProvider(name = "testFileConstructorSize")
    public Object[][] testFileConstructorSize() {
        return new Object[][]{
                {"Test.txt", content},
                {"Test.txt", content + "x"}
        };
    }

    @DataProvider(name = "testFileConstructorExtension")
    public Object[][] testFileConstructorExtension() {
        return new Object[][]{
                {"Test.", content, ""},
                {"Test.txt", content, "txt"}
        };
    }

    @DataProvider(name = "testFileException")
    public Object[][] testFileException() {
        return new Object[][]{
                {"Test.txt", content},
                {"", content}
        };
    }

    @DataProvider(name = "testFile")
    public Object[][] testFile() {
        return new Object[][]{
                {"Test.1", content},
                {"Test.txt", content}
        };
    }

    @Test(dataProvider = "testFile")
    public void testConstructorFilename(String filename, String content) throws NoSuchFieldException, IllegalAccessException {
        File file = new File(filename, content);
        String testFilename = ReflectionForTest.getFileName(file);
        Assert.assertEquals(testFilename, filename, "wrong filename in constructor File");
    }

    @Test(dataProvider = "testFile")
    public void testConstructorContent(String filename, String content) throws NoSuchFieldException, IllegalAccessException {
        File file = new File(filename, content);
        String testContent = ReflectionForTest.getFileContent(file);
        Assert.assertEquals(testContent, content, "wrong content in constructor File");
    }

    @Test(expectedExceptions = FileAlreadyExistsException.class)
    public void testConstructorException() {
        new File(filename, content);
        new File(filename, content);
    }

    @Test(dataProvider = "testFileConstructorSize")
    public void testConstructorSize(String filename, String content) throws IllegalAccessException, NoSuchFieldException {
        File file = new File(filename, content);
        int size = (int) ReflectionForTest.getFileSize(file);
        int testSize;
        if (content.length() % 2 != 0)
            testSize = content.length() / 2 + 1;
        else testSize = content.length() / 2;
        Assert.assertEquals(size, testSize, "wrong size in constructor File");
    }

    @Test(dataProvider = "testFileConstructorExtension")
    public void testConstructorExtension(String filename, String content, String testExtension) throws IllegalAccessException, NoSuchFieldException {
        File file = new File(filename, content);
        String ext = ReflectionForTest.getFileExtension(file);
        Assert.assertEquals(ext, testExtension, "wrong extension in constructor File");
    }

    @Test(dataProvider = "testFile")
    public void testGetExtension(String filename, String content) throws IllegalAccessException, NoSuchFieldException {
        File file = new File(filename, content);
        String ext = ReflectionForTest.getFileExtension(file);
        Assert.assertEquals(file.getExtension(), ext, "method getExtension return wrong extension");
    }

    @Test(dataProvider = "testFile")
    public void testGetSize(String filename, String content) throws IllegalAccessException, NoSuchFieldException {
        File file = new File(filename, content);
        int size = (int) ReflectionForTest.getFileSize(file);
        Assert.assertEquals(file.getSize(), size, "method getSize return wrong size");
    }

    @Test(dataProvider = "testFile")
    public void testGetContent(String filename, String content) {
        Assert.assertEquals(new File(filename, content).getContent(), content, "method getContent return wrong content");
    }

    @Test(dataProvider = "testFile")
    public void testGetFilename(String filename, String content) {
        Assert.assertEquals(new File(filename, content).getFilename(), filename, "method getFilename return wrong filename");
    }
}