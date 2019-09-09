package app.form;

import framework.elements.Button;

public class Header {
    private String locate = " on Header";
    private String buttonInstallLocator = "//div[contains(@class, 'header_installsteam_btn header_installsteam_btn_green')]";
    private Button buttonInstall = new Button(buttonInstallLocator, "buttonInstall" + locate);

    public void clickOnButtonInstall() {
        buttonInstall.clickElement();
    }

    public boolean isDisplayedButtonInstall() {
        return buttonInstall.isDispl();
    }

}
