package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;

public class BrowserSingleton {
    private static WebDriver driver;

    private BrowserSingleton() {
    }

    public static WebDriver getInstance(String browser) throws IllegalBrowserNameException {
        if (driver == null) {
            switch (browser){
                case "chrome":
                    WebDriverManager.getInstance(CHROME).setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.getInstance(FIREFOX).setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new IllegalBrowserNameException();
            }
        }
        return driver;
    }
}
