package framework.elements;

import org.openqa.selenium.By;

public class DropDownMenu extends BaseElement {
    public DropDownMenu(By locator, String nameElement) {
        super(locator, nameElement);
    }

    public void clickSelectElement(int selectNumber) {
//        Select select = new Select(getElement());
//        select.selectByIndex(selectNumber);

        getElements().get(selectNumber).click();
    }

    public String getTextSelectElement(int selectNumber) {
        return getElements().get(selectNumber).getText();
    }
}
