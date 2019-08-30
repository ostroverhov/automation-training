package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    By logoTextLocator = By.xpath("//a[@class='logo logo_type_link logo_part_market']//span[@class='logo__text'] ");
    By loginButtonLocator = By.xpath("//div[@class='n-passport-suggest-popup-opener']");

    public String getMainPageLogoText() {
        return driver.findElement(logoTextLocator).getText();
    }

    public WebElement getButtonLogin(){
        return driver.findElement(loginButtonLocator);
    }

    public boolean buttonLoginIsDisplayed(){
        return getButtonLogin().isDisplayed();
    }

    public void clickButtonLogin(){
        getButtonLogin().click();
    }
}
