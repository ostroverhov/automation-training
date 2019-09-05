package app.form;

import framework.elements.Button;
import framework.elements.SubMenu;

public class TopMenu {
    String locate = " на TopMenu";
    String topMenuButtonLocator = "//a[@class='pulldown_desktop'][contains(text(), '%s')]";
    String popupMenuLocator = "//a[@class='popup_menu_item'][contains(text(), '%s')]";

    String nameDropDownMenuItem;

    private Button getButtonFromMenu(String nameButton) {
        return new Button(String.format(topMenuButtonLocator, nameButton), "buttonInTopMenu" + locate);
    }

    private SubMenu getDropDownMenu(String nameDropDownMenuItem) {
        return new SubMenu(String.format(popupMenuLocator, nameDropDownMenuItem), "DropDownMenu" + locate);
    }

    public void navigateToTabMenu(String nameButton) {
        getButtonFromMenu(nameButton).navigateToButton();
    }

    public void clickToDropDownMenuItem(String nameItem) {
        getDropDownMenu(nameItem).clickElement();
        nameDropDownMenuItem = getDropDownMenu(nameItem).getTextFromElement();
    }

    public String getNameDropDownMenuItem(){
        return nameDropDownMenuItem;
    }
}
