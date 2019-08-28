package application;

import browser.Browser;
import framework.Writer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPageLogin {
    WebDriver driver;

    By logoUserLocator = By.xpath("//div[@class='n-passport-suggest-popup-opener']");
    By butonAllCategory = By.xpath("//div[@class='n-w-tab__control b-zone b-spy-events i-bem n-w-tab__control_js_inited']");
    By panelAllCategory = By.xpath("//div[@class='n-w-tabs__vertical-tabs']//a[@class='link n-w-tab__control b-zone b-spy-events']");
    By buttonLogout = By.xpath("//li[@class='header2-user-menu__item']");


    public MainPageLogin(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getLogoUser(){
        return driver.findElement(logoUserLocator).isDisplayed();
    }

    public List<String> clickAllCategories() throws IOException {
        driver.findElement(butonAllCategory).click();
        List<WebElement> catalogAllCategory = driver.findElements(panelAllCategory);
        List<String> listNameAllCategory = new ArrayList<>();
        for (WebElement w : catalogAllCategory) {
            w.getText();
            listNameAllCategory.add(w.getText());
        }
        Writer.writeCategoryCSV(listNameAllCategory);
        return listNameAllCategory;
    }

    public void clickLogout() {
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(logoUserLocator)).build().perform();
        actions.click(driver.findElement(buttonLogout)).build().perform();
    }
}
