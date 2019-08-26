package browser;

import org.openqa.selenium.WebDriver;

public class Browser {
    public Browser() {
    }

    public static void switchTab(WebDriver driver){
        for (String tab:driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }



}
