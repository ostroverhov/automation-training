package application;

import framework.Writer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPageLogin extends BasePage {

    By logoUserLocator = By.xpath("//div[@class='n-passport-suggest-popup-opener']");
    By butonAllCategory = By.xpath("//div[@class='n-w-tab__control b-zone b-spy-events i-bem n-w-tab__control_js_inited']");
    By panelAllCategory = By.xpath("//div[@class='n-w-tabs__vertical-tabs']//a[@class='link n-w-tab__control b-zone b-spy-events']");
    By buttonLogout = By.xpath("//li[@class='header2-user-menu__item']");

    public boolean logoUserIsDisplayed() {
        return driver.findElement(logoUserLocator).isDisplayed();
    }

    public List<WebElement> clickAllCategories() {
        driver.findElement(butonAllCategory).click();
        return driver.findElements(panelAllCategory);
    }

    public List<String> getWriteAllCategories() throws IOException {
        List<WebElement> catalogAllCategory = clickAllCategories();
        List<String> listNameAllCategory = new ArrayList<>();
        for (WebElement w : catalogAllCategory) {
            w.getText();
            listNameAllCategory.add(w.getText());
        }
        Writer.writeCategory(listNameAllCategory, "category.csv");
        return listNameAllCategory;
    }

    public void clickLogout() {
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(logoUserLocator)).build().perform();
        actions.click(driver.findElement(buttonLogout)).build().perform();
    }
}
