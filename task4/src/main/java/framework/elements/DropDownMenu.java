package framework.elements;

import framework.utils.RandomElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownMenu extends BaseElement {
    public DropDownMenu(By locator, String nameElement) {
        super(locator, nameElement);
    }

    public String getRandomElement() {
        Select select = new Select(getElement());
        List<WebElement> dropDownElements = select.getAllSelectedOptions();
        int random = RandomElements.getRandom(dropDownElements.size());
        return dropDownElements.get(random).getText();
    }

    public void clickSelectElement(String selectElement) {
        Select select = new Select(getElement());
        select.selectByVisibleText(selectElement);

//        getElements().get(selectNumber).click();
    }

//    public String getTextSelectElement(int selectNumber) {
//        return getElements().get(selectNumber).getText();
//    }
}
