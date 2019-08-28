package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;

    By logoTextLocator = By.xpath("//a[@class='logo logo_type_link logo_part_market']//span[@class='logo__text'] ");
    By loginButtonLocator = By.xpath("//div[@class='n-passport-suggest-popup-opener']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMainPageLogoText() {
        return driver.findElement(logoTextLocator).getText().toLowerCase();
    }

    public WebElement getButtonLogin(){
        return driver.findElement(loginButtonLocator);
    }

    public void clickButtonLogin(){
        getButtonLogin().click();
    }
}
