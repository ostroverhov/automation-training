package app.form;

import framework.elements.Panel;
import org.openqa.selenium.By;

public class TrimCard {
    private String locate = " on TrimCard";

    private Panel panelEngine = new Panel(By.xpath("//div[contains(@class,'cell cell-bg grow-2')]"), "panelEngine" + locate);
    private Panel panelTrans = new Panel(By.xpath("//div[contains(@class,'cell grow-2')]"), "panelTrans" + locate);

    public String getTextPanelEngine() {
        return panelEngine.getTextFromElement();
    }

    public boolean isDisplPanelEngine() {
        return panelEngine.isDisplayedElement();
    }

    public String getTextPanelTrans() {
        return panelTrans.getTextFromElement();
    }
}
