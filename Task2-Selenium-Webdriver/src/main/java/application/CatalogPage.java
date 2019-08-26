package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage {
    WebDriver driver;
    List<String> catalogTop = new ArrayList<>();

    By menuTopLocator = By.xpath("//span[@class='n-w-tab__control-caption']");

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getArrayCatalog() {

        List<WebElement> catalog = driver.findElements(menuTopLocator);

        for (WebElement w : catalog) {
            w.getText();
            System.out.println(w.getText());
            catalogTop.add(w.getText());
        }


        return catalogTop;
    }
}
