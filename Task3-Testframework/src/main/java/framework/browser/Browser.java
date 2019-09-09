package framework.browser;

import framework.utils.MyLogger;
import framework.utils.Reader;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    public Browser() {
    }

    private static WebDriver initBrowser() {
        return BrowserFactory.getInstance(Reader.getParametr("browser"));
    }

    public static void setMaxSizeWindow() {
        MyLogger.info(" set max size window");
        initBrowser().manage().window().maximize();
    }

    public static void setURL(String URL) {
        MyLogger.info(" set URL");
        initBrowser().get(URL);
    }
}
