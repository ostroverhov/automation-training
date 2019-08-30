package application;

import browser.Browser;
import browser.IllegalBrowserNameException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CatalogPage extends BasePage {
    List<WebElement> catalogPopularCategory;

    By menuPopularCategoryLocator = By.xpath("//div[@class='n-w-tabs__horizontal-tabs']//div[@class='n-w-tab n-w-tab_type_navigation-menu'] ");
    By logoToMainPageLocator = By.xpath("//a[@class='logo logo_type_link logo_part_market']");

    public List<WebElement> getArrayPopularCategory() {
        catalogPopularCategory = driver.findElements(menuPopularCategoryLocator);
        return catalogPopularCategory;
    }

    public int getSizeCatalogPopularCategory(){
        return catalogPopularCategory.size();
    }

    public void clickCategory(int random) {
        catalogPopularCategory.get(random).click();
    }

    public String getNameCategory(int random) {
        return catalogPopularCategory.get(random).getText();
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
