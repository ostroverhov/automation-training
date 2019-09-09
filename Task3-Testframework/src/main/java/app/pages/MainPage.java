package app.pages;

import app.form.Header;
import app.form.TopMenu;

public class MainPage {
    private Header header = new Header();
    private TopMenu topMenu = new TopMenu();

    public Header getHeader() {
        return header;
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
