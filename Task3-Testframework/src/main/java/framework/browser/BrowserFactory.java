package framework.browser;

import framework.utils.MyLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

public class BrowserFactory {
    private static WebDriver driver;

    private BrowserFactory() {
    }

    public static WebDriver getInstance(String browser) throws IllegalBrowserNameException {
        if (driver == null) {
            MyLogger.info(" инициализация драйвера " + browser);
            switch (browser){
                case "chrome":
                    WebDriverManager.getInstance(CHROME).setup();
                    driver = new ChromeDriver(BrowserSettings.chromeSettings());
                    break;
                case "firefox":
                    WebDriverManager.getInstance(FIREFOX).setup();
                    driver = new FirefoxDriver(BrowserSettings.firefoxSettings());
                    break;
                default:
                    MyLogger.warn("Невенрно выбран браузер");
                    throw new IllegalBrowserNameException();
            }
        }
        return driver;
    }

    public static void closeBrowser() {
        MyLogger.info(" закрытие драйвера");
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    public static void setMaxSizeWindow() {
        MyLogger.info(" установка максимального размера окна");
        driver.manage().window().maximize();
    }

    public static void setURL(String URL) {
        MyLogger.info(" установка URL " + URL);
        driver.get(URL);
    }
}
