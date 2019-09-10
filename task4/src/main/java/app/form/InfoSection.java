package app.form;

import framework.elements.Button;
import framework.elements.Panel;

public class InfoSection {
    private String locate = " on InfoSection";
    private String buttonCompareTrimLocator = "//td[@class='mmy-spec__compare']//a";
    private String panelInfoCarLocator = "//h1[@class='cui-page-section__title']";

    public void clickOnButtonCompareTrim() {
        getButtonCompareTrim().clickElement();
    }

    public String getTextPanelInfoCar() {
        return getPanelInfoCar().getTextFromElement();
    }

    public boolean buttonIsPresent(){
        return getButtonCompareTrim().isPresent();
    }

    private Button getButtonCompareTrim() {
        return new Button(buttonCompareTrimLocator, "compare trim button" + locate);
    }

    private Panel getPanelInfoCar() {
        return new Panel(panelInfoCarLocator, "panel info about car" + locate);
    }
}
