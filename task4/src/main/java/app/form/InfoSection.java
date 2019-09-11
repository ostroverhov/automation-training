package app.form;

import framework.elements.Button;
import framework.elements.Panel;

public class InfoSection {
    private String locate = " on InfoSection";
    private String buttonCompareTrimLocator = "//td[@class='mmy-spec__compare']//a";
    private String panelInfoCarLocator = "//h1[@class='cui-page-section__title']";

    private Button buttonCompareTrim = new Button(buttonCompareTrimLocator, "compare trim button" + locate);
    private Panel panelInfoCar = new Panel(panelInfoCarLocator, "panel info about car" + locate);

    public void clickOnButtonCompareTrim() {
        buttonCompareTrim.clickElement();
    }

    public String getTextPanelInfoCar() {
        return panelInfoCar.getTextFromElement();
    }

    public boolean buttonIsPresent() {
        return buttonCompareTrim.isPresent();
    }
}
