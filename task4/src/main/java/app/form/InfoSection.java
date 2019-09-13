package app.form;

import framework.elements.Button;
import framework.elements.Panel;
import org.openqa.selenium.By;

public class InfoSection {
    private String locate = " on InfoSection";

    private Button buttonCompareTrim = new Button(By.xpath("//td[@class='mmy-spec__compare']//a"), "compare trim button" + locate);
    private Panel panelInfoCar = new Panel(By.xpath("//h1[@class='cui-page-section__title']"), "panel info about car" + locate);

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
