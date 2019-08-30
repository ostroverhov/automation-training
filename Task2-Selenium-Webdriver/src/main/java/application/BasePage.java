package application;

import browser.Browser;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    WebDriver driver = Browser.initBrowser();
}
