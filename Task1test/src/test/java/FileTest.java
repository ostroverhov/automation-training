import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

public class FileTest {
    String content = "test content";

    @DataProvider(name = "testFileConstructorSize")
    public Object[][] testFileConstructorSize() {
        return new Object[][]{
                {"Test.txt", content, 6},
                {"Test.txt", content + "x", 7}
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
                {"Test.", content},
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
    public void testConstructor(String filename, String content) {
        Assert.assertNotNull(new File(filename, content));
    }

    @Test(dataProvider = "testFileException")
    public void testConstructorException(String filename, String content) {
        System.out.println(new File(filename, content).getFilename());
        try {
            new File(filename, content);
            Assert.fail("Expected Exception");
        } catch (Exception thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test(dataProvider = "testFileConstructorSize")
    public void testConstructorSize(String filename, String content, int testSize) throws IllegalAccessException {
        File file = new File(filename, content);
        int size = 0;
        try {
            Field field = file.getClass().getDeclaredField("size");
            field.setAccessible(true);
            size = (int) field.getDouble(file);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(size, testSize);
    }

    @Test
    public void testConstructorTypeSize() {
        String filename = "Test.txt";
        File file = new File(filename, content);
        Class<?> typeSize = null;
        try {
            Field field = file.getClass().getDeclaredField("size");
            typeSize = field.getType();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(typeSize, "int");
    }

    @Test(dataProvider = "testFileConstructorExtension")
    public void testConstructorExtension(String filename, String content, String testExtension) throws IllegalAccessException {
        File file = new File(filename, content);
        String ext = new String();
        try {
            Field field = file.getClass().getDeclaredField("extension");
            field.setAccessible(true);
            ext = (String) field.get(file);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(ext, testExtension);
    }

    @Test(dataProvider = "testFile")
    public void testGetExtension(String filename, String content) throws IllegalAccessException {
        File file = new File(filename, content);
        String ext = new String();
        try {
            Field field = file.getClass().getDeclaredField("extension");
            field.setAccessible(true);
            ext = (String) field.get(file);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();

        }
        Assert.assertEquals(file.getExtension(), ext);
    }

    @Test(dataProvider = "testFile")
    public void testGetSize(String filename, String content) throws IllegalAccessException {
        File file = new File(filename, content);
        int size = 0;
        try {
            Field field = file.getClass().getDeclaredField("size");
            field.setAccessible(true);
            size = (int) field.getDouble(file);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(file.getSize(), size);
    }

    @Test(dataProvider = "testFile")
    public void testGetContent(String filename, String content) {
        Assert.assertEquals(new File(filename, content).getContent(), content);
    }

    @Test(dataProvider = "testFile")
    public void testGetFilename(String filename, String content) {
        Assert.assertEquals(new File(filename, content).getFilename(), filename);
    }
}