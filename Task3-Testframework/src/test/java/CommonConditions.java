import framework.browser.Browser;
import framework.browser.BrowserFactory;
import framework.utils.Directories;
import framework.utils.MyLogger;
import framework.utils.Reader;
import framework.utils.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    String URL = Reader.getParametr("URL");
    int timeout = Integer.parseInt(Reader.getParametr("timeout"));

    @BeforeMethod
    public void setUp() {
        MyLogger.step("Start test");
        Wait.setImplicityWait(timeout);
        Browser.setMaxSizeWindow();
        Browser.setURL(URL);
        Directories.cleanDirectory(Reader.getParametr("path"));
    }

    @AfterMethod
    public void tearDown() {
        MyLogger.step("Test finish");
        BrowserFactory.closeBrowser();
    }
}
