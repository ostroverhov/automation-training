package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CatalogPage {
    WebDriver driver;

    By menuPopularCategoryLocator = By.xpath("//div[@class='n-w-tabs__horizontal-tabs']//div[@class='n-w-tab n-w-tab_type_navigation-menu'] ");
    By logoToMainPageLocator = By.xpath("//a[@class='logo logo_type_link logo_part_market']");

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getArrayPopularCategory() {
        List<WebElement> catalogPopularCategory = driver.findElements(menuPopularCategoryLocator);
        return catalogPopularCategory;
    }

    public void clickRandomCategory(List<WebElement> catalog, int random) {
        catalog.get(random).click();
    }

    public String getNameRandomcategory(List<WebElement> catalog, int random) {
        return catalog.get(random).getText().toLowerCase();
    }

    public void clickMainPageLogin() {
        driver.findElement(logoToMainPageLocator).click();
    }

    public List<String> getListPopularCategory() {
        List<WebElement> arrayPopularCategory = driver.findElements(menuPopularCategoryLocator);
        List<String> listPopularCategory = new ArrayList<>();
        for (WebElement w : arrayPopularCategory) {
            if (w.isDisplayed()) {
                listPopularCategory.add(w.getText());
            }
        }
        return listPopularCategory;
    }
}
