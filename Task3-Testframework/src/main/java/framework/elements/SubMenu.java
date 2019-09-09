package framework.elements;

import app.projectUtils.Discount;
import framework.utils.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SubMenu extends BaseElement {
    private List<WebElement> subMenu;

    public SubMenu(String locator, String nameElement) {
        super(locator, nameElement);
    }

    public static List<Integer> getListDiscountfromSubMenu(List<WebElement> subMenu) {
        MyLogger.info("Get game with max discount");
        List<Integer> discount = new ArrayList<>();
        for (WebElement w : subMenu) {
            discount.add(Discount.getNumberDiscount(w.getText()));
        }
        return discount;
    }

    public static String getTextSubMenuItem(int index, String path, List<WebElement> subMenu){
        return subMenu.get(index).findElement(By.xpath(path)).getText();
    }
}
