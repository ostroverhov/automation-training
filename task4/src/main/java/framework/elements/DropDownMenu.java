package framework.elements;

import framework.utils.MyLogger;
import framework.utils.RandomElements;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DropDownMenu extends BaseElement {
    public DropDownMenu(String locator, String nameElement) {
        super(locator, nameElement);
    }

    public void clickRandom(int random) {
        getElements().get(random).click();
    }

    public String getTextRandom(int random) {
        return getElements().get(random).getText();
    }
}
