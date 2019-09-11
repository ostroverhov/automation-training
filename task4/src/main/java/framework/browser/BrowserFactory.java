package framework.browser;

import framework.utils.MyLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

public class BrowserFactory {
    private static WebDriver driver;

    private BrowserFactory() {
    }

    public static WebDriver getInstance(String browser) throws IllegalBrowserNameException {
        if (driver == null) {
            MyLogger.info(" driver init " + browser);
            switch (browser) {
                case "chrome":
                    WebDriverManager.getInstance(CHROME).setup();
                    driver = new ChromeDriver(BrowserSettings.chromeSettings());
                    break;
                case "firefox":
                    WebDriverManager.getInstance(FIREFOX).setup();
                    driver = new FirefoxDriver(BrowserSettings.firefoxSettings());
                    break;
                default:
                    MyLogger.warn(" browser wasn't select ");
                    throw new IllegalBrowserNameException();
            }
        }
        return driver;
    }

    public static void closeBrowser() {
        MyLogger.info(" close driver");
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    public static void setMaxSizeWindow() {
        MyLogger.info(" set max size window");
        driver.manage().window().maximize();
    }

    public static void setURL(String URL) {
        MyLogger.info(" set URL " + URL);
        driver.get(URL);
    }

    public static void goToMainPage(String URL) {
        MyLogger.info(" go to main page");
        driver.navigate().to(URL);
    }
}
