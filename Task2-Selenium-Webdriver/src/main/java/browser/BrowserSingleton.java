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

    public static WebDriver getInstance(String browser) {
        if (driver == null) {
            if (browser.equals("chrome")) {
                WebDriverManager.getInstance(CHROME).setup();
                driver = new ChromeDriver();
            } else if (browser.equals("firefox")) {
                WebDriverManager.getInstance(FIREFOX).setup();
                driver = new FirefoxDriver();
            }
            else System.out.println("выберите браузер: chrome / firefox");
        }
        return driver;
    }
}
