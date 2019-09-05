package framework.utils;

import app.pages.ValidateBirthdayPage;
import framework.browser.BrowserFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Wait {

    public static void setImplicityWait(int timeout) {
        BrowserFactory.getInstance(Reader.getParametr("browser")).manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }


    public static void waitForFile(File file) {
        FluentWait wait = new FluentWait(BrowserFactory.getInstance(Reader.getParametr("browser"))).
                withTimeout(Integer.parseInt(Reader.getParametr("timeout")), TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
        wait.until((Function) (webDriver) -> file.exists());
    }
}
