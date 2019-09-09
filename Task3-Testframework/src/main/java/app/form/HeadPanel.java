package app.form;

import framework.elements.Panel;

public class HeadPanel {
    private String locate = " on HeadPanel";
    private String panelNameLocator = "//h2[@class='pageheader']";
    private Panel panelName = new Panel(panelNameLocator, "PanelName" + locate);

    public String getPanelNameText() {
        return panelName.getTextFromElement();
    }
}
