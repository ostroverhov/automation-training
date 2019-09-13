package app.form;

import framework.elements.Button;
import org.openqa.selenium.By;

public class TopMenu {
    private String locate = " on TopMenu";

    private Button buttonLogoMainPage = new Button(By.xpath("//a[@class='_3WG8F _3xBVO']"), "buttonLogo" + locate);

    private Button getButtonTopMenuMainPage(String nameButton) {
        return new Button(By.xpath(String.format("//ul[@class='_1U4gk']//a[@class='_2Qal_'][contains(text(), '%s')]", nameButton)), nameButton + " button" + locate);
    }

    private Button getButtonTopMenu(String nameButton) {
        return new Button(By.xpath(String.format("//ul[@class='global-nav__parent']//a[@class='global-nav__link'][contains(text(),'%s')]", nameButton)), nameButton + " button" + locate);
    }

    public void clickOnButtonTopMenuMain(MenuHeaderItem nameButton) {
        getButtonTopMenuMainPage(nameButton.getMenuItem()).clickElement();
    }

    public void clickOnButtonTopMenu(MenuHeaderItem nameButton) {
        getButtonTopMenu(nameButton.getMenuItem()).clickElement();
    }

    public boolean isDisplButtonLogoMainPage() {
        return buttonLogoMainPage.isDisplayedElement();
    }
}
