package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputLoginPage extends BasePage {

    By fieldInputLoginLocator = By.xpath("//input[@id='passp-field-login']");
    By buttonLoginLocator = By.xpath("//button[@class='control button2 button2_view_classic button2_size_l button2_theme_action button2_width_max button2_type_submit passp-form-button'] ");

    public void setLogin(String login) {
        driver.findElement(fieldInputLoginLocator).sendKeys(login);
        driver.findElement(buttonLoginLocator).click();
    }

}
