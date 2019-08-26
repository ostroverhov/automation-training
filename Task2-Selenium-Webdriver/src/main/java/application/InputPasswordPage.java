package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputPasswordPage {
    WebDriver driver;

    By loginFieldPasswordLocator = By.xpath("//div[@class='passp-auth-screen passp-welcome-page passp-route-enter-done'] ");
    By fieldInputPasswordLocator = By.xpath("//input[@id='passp-field-passwd']");
    By buttonPasswordLocator = By.xpath("//button[@class='control button2 button2_view_classic button2_size_l button2_theme_action button2_width_max button2_type_submit passp-form-button'] ");

    public InputPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginFieldText() {  //для проверки
        return driver.findElement(loginFieldPasswordLocator).getText();
    }

    public void setPassword(String password) {
        driver.findElement(fieldInputPasswordLocator).sendKeys(password);
        driver.findElement(buttonPasswordLocator).click();
    }

}
