package app.form;

import framework.elements.Panel;

public class HeadPanel {
    String locate = " на HeadPanel";
    String panelNameLocator = "//h2[@class='pageheader']";

    private Panel getPanelName() {
        return new Panel(panelNameLocator, "PanelName" + locate);
    }

    public String getPanelNameText(){
        return getPanelName().getTextFromElement();
    }
}
