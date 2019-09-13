package framework.utils;

import framework.browser.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait {

    public static void setImplicityWait(int timeout) { //todo brawser
        BrowserFactory.getInstance(Reader.getParametr("browser")).manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public static WebElement waitElementToBeClickable(WebElement element) {//todo base element
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getInstance(Reader.getParametr("browser")), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
