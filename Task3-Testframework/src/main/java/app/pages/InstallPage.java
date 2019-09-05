package app.pages;

import framework.elements.Button;

public class InstallPage {
    String locate = " на InstallPage";
    String buttonInstallLocator = "//a[@class='about_install_steam_link']";

    public Button getButton(){
        return new Button(buttonInstallLocator, "buttonInstall" + locate);
    }

    public void clickButtonInstall() {
        getButton().clickElement();
    }

    public boolean isDisplayedButtonInstall(){
        return getButton().isDispl();
    }
}
