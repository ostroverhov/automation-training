package framework.utils;

import framework.browser.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static WebElement waitElements(WebElement element){
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getInstance(Reader.getParametr("browser")), 10);
        return  wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
