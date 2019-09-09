package app.pages;

import app.form.TabsMenu;
import app.form.HeadPanel;

public class GenrePage {
    private TabsMenu tabsMenu = new TabsMenu();
    private HeadPanel headPanel = new HeadPanel();

    public TabsMenu getTabsMenu() {
        return tabsMenu;
    }

    public HeadPanel getHeadPanel() {
        return headPanel;
    }
}
