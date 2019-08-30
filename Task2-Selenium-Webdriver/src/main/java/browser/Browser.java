package browser;

import framework.Reader;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Browser {

    public Browser() {
    }

    public static void switchTab(WebDriver driver) {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    public static WebDriver initBrowser() {
        return BrowserSingleton.getInstance(Reader.getParametr("browser"));
    }

    public static void setTimeToWait(WebDriver driver, int timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public static void setMaxSizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void setURL(WebDriver driver, String URL) {
        driver.get(URL);
    }

    public static void closeBrowser(WebDriver driver) {
        driver.quit();
    }
}
