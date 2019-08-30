package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RandomCategoryPage extends BasePage {

    By nameCategoryLocator = By.xpath("//div[@data-apiary-widget-name]");

    public String getNamePage() {
        return driver.findElement(nameCategoryLocator).getAttribute("innerText");
    }
}
