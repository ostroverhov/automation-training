package app.form;

import framework.elements.Panel;

public class TrimCard {
    private String locate = " on TrimCard";
    private String engineLocator = "//div[contains(@class,'cell cell-bg grow-2')]";
    private String transLocator = "//div[contains(@class,'cell grow-2')]";

    private Panel panelEngine = new Panel(engineLocator, "panelEngine" + locate);
    private Panel panelTrans = new Panel(transLocator, "panelTrans" + locate);

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
