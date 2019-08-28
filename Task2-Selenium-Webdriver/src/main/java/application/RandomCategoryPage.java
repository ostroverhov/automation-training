package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RandomCategoryPage {
    WebDriver driver;

    By nameCategoryLocator = By.xpath("//h1[@class='_39qdPorEKz']");

    public RandomCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNamePage(){
        return driver.findElement(nameCategoryLocator).getAttribute("innerText").toLowerCase();
    }
}
