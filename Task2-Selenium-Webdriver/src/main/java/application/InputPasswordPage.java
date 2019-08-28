package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputPasswordPage {
    WebDriver driver;

    By fieldInputPasswordLocator = By.cssSelector("input#passp-field-passwd");
    By buttonPasswordLocator = By.cssSelector("div[class='passp-button passp-sign-in-button'] ");

    public InputPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setPassword(String password) {
        driver.findElement(fieldInputPasswordLocator).sendKeys(password);
        driver.findElement(buttonPasswordLocator).click();
    }

}
