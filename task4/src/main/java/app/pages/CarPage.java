package app.pages;

import app.form.InfoSection;
import app.form.TopMenu;

public class CarPage {
    private InfoSection infoSection = new InfoSection();
    private TopMenu topMenu = new TopMenu();

    public InfoSection getInfoSection() {
        return infoSection;
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
