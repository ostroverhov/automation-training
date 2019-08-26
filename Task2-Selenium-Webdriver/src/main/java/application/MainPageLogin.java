package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageLogin {
    WebDriver driver;

    By logoUserLocator = By.xpath("//div[@class='header2__nav']");

    public MainPageLogin(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getLogoUser(){
        return driver.findElement(logoUserLocator).isDisplayed();
    }

}
