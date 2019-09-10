package app.form;

import framework.elements.Panel;

public class TrimCard {
    private String locate = " on TrimCard";
    private String engineLocator = "//div[contains(@class,'cell cell-bg grow-2')]";
    private String transLocator = "//div[contains(@class,'cell grow-2')]";

    private Panel getPanelEngine() {
        return new Panel(engineLocator, "panelEngine" + locate);
    }

    private Panel getPanelTrans() {
        return new Panel(transLocator, "panelTrans" + locate);
    }

    public String getTextPanelEngine() {
        return getPanelEngine().getTextFromElement();
    }

    public boolean isDisplPanelEngine(){
        return getPanelEngine().isDispl();
    }

    public String getTextPanelTrans() {
        return getPanelTrans().getTextFromElement();
    }
}
