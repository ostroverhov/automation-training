package app.form;

import framework.elements.Button;
import framework.elements.DropDownList;
import framework.elements.Panel;

public class ValidateBirthdayForm {
    String locate = " на ValidateBirthdayForm";

    String yearAgeLocator = "//option[contains(text(),'1993')]";
    String viewPageButtonLocator = "//a[@class='btnv6_blue_hoverfade btn_medium']";
    String panelAgeLocator = "//div[@id='app_agegate']";

    private DropDownList getDropDownList(){
        return new DropDownList(yearAgeLocator, "DropDownList" + locate);
    }

    private Button getButtonViewPage(){
        return new Button(viewPageButtonLocator, "ButtonViewPage"  + locate);
    }

    private Panel getPanelAge(){
        return new Panel(panelAgeLocator, "PanelAge" + locate);
    }

    public void inputAge(){
        getDropDownList().clickElement();
    }

    public void clickButtonVievPage(){
        getButtonViewPage().clickElement();
    }

    public boolean panelAgeIsDispl(){
        return getPanelAge().isDispl();
    }
}
