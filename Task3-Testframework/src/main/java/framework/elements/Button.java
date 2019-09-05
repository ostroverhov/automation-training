package framework.elements;

import framework.browser.BrowserFactory;
import framework.utils.Reader;
import org.openqa.selenium.interactions.Actions;

public class Button extends BaseElement {
    Actions actions = new Actions(BrowserFactory.getInstance(Reader.getParametr("browser")));

    public Button(String locator, String nameElement) {
        super(locator, nameElement);
    }

    public void navigateToButton() {
        actions.moveToElement(getElement()).build().perform();
    }
}
