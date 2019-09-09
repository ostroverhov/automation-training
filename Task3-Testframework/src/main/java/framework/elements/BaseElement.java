package framework.elements;

import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import framework.utils.Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BaseElement {
    String nameElement;
    String locator;

    public BaseElement(String locator, String nameElement) {
        MyLogger.info("  create element " + nameElement);
        this.nameElement = nameElement;
        this.locator = locator;
    }

    public WebElement getElement() {
        MyLogger.info("  get element "+ nameElement);
        return BrowserFactory.getInstance(Reader.getParametr("browser")).findElement(By.xpath(locator));
    }

    public List<WebElement> getElements() {
        MyLogger.info("  get elements " + nameElement);
        return BrowserFactory.getInstance(Reader.getParametr("browser")).findElements(By.xpath(locator));
    }

    public boolean isDispl() {
        MyLogger.info("  element is displayed " + nameElement);
        return BrowserFactory.getInstance(Reader.getParametr("browser")).findElement(By.xpath(locator)).isDisplayed();
    }

    public void clickElement() {
        MyLogger.info("  click on element " + nameElement);
        BrowserFactory.getInstance(Reader.getParametr("browser")).findElement(By.xpath(locator)).click();
    }

    public String getTextFromElement() {
        MyLogger.info("  get text from element " + nameElement);
        return BrowserFactory.getInstance(Reader.getParametr("browser")).findElement(By.xpath(locator)).getText();
    }
}
