package app.form;

import framework.elements.Button;

public class TopMenu {
    private String locate = " on TopMenu";
    private String buttonTopMenuMainPageLocator = "//ul[@class='_1U4gk']//a[@class='_2Qal_'][contains(text(), '%s')]";
    private String buttonTopMenuLocator = "//ul[@class='global-nav__parent']//a[@class='global-nav__link'][contains(text(),'%s')]";
    private String buttonLogoMainPageLocator = "//a[@class='_3WG8F _3xBVO']";

    private Button buttonLogoMainPage = new Button(buttonLogoMainPageLocator, "buttonLogo" + locate);

    private Button getButtonTopMenuMainPage(String nameButton) {
        return new Button(String.format(buttonTopMenuMainPageLocator, nameButton), nameButton + " button" + locate);
    }

    private Button getButtonTopMenu(String nameButton) {
        return new Button(String.format(buttonTopMenuLocator, nameButton), nameButton + " button" + locate);
    }

    public void clickOnButtonTopMenuMain(String nameButton) {
        getButtonTopMenuMainPage(nameButton).clickElement();
    }

    public void clickOnButtonTopMenu(String nameButton) {
        getButtonTopMenu(nameButton).clickElement();
    }

    public boolean isDisplButtonLogoMainPage() {
        return buttonLogoMainPage.isDisplayedElement();
    }
}
