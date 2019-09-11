import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import framework.utils.Reader;
import framework.utils.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    public static String URL = Reader.getParametr("URL");
    int timeout = Integer.parseInt(Reader.getParametr("timeout"));

    @BeforeMethod
    public void setUp() {
        MyLogger.step("Start test");
        Wait.setImplicityWait(timeout);
        BrowserFactory.setMaxSizeWindow();
        BrowserFactory.setURL(URL);
    }

    @AfterMethod
    public void tearDown() {
        MyLogger.step("Finish test");
        BrowserFactory.closeBrowser();
    }
}
