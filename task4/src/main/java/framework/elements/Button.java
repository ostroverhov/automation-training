package framework.elements;

import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import framework.utils.Reader;
import org.openqa.selenium.interactions.Actions;

public class Button extends BaseElement {
    public Button(String locator, String nameElement) {
        super(locator, nameElement);
    }
}
