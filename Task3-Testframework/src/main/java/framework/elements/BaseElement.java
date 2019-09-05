package framework.elements;

import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import framework.utils.Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class BaseElement {
    WebElement element;
    List<WebElement> elements;
    String nameElement;

    public BaseElement(String locator, String nameElement) {
        MyLogger.info("  создание элемента " + nameElement);
        element = BrowserFactory.getInstance(Reader.getParametr("browser")).findElement(By.xpath(locator));
        elements = BrowserFactory.getInstance(Reader.getParametr("browser")).findElements(By.xpath(locator));
        this.nameElement = nameElement;
    }

    public WebElement getElement() {
        MyLogger.info("  получение элемента "+ nameElement);
        return element;
    }

    public List<WebElement> getElements() {
        MyLogger.info("  получение элементов " + nameElement);
        return elements;
    }

    public boolean isDispl() {
        MyLogger.info("  элемент отображается " + nameElement);
        return element.isDisplayed();
    }

    public void clickElement() {
        MyLogger.info("  клик по элементу " + nameElement);
        element.click();
    }

    public String getTextFromElement() {
        MyLogger.info("  получение текста из элемента " + nameElement);
        return element.getText();
    }
}
