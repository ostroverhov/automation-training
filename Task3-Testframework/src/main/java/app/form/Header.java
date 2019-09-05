package app.form;

import framework.elements.Button;

public class Header {
    String locate = " на Header";
    String buttonInstallLocator = "//div[contains(@class, 'header_installsteam_btn header_installsteam_btn_green')]";

    private Button getButton(){
        return new Button(buttonInstallLocator, "buttonInstall" + locate);
    }

    public void clickOnButtonInstall() {
        getButton().clickElement();
    }

    public boolean isDisplayedButtonInstall(){
        return getButton().isDispl();
    }

}
