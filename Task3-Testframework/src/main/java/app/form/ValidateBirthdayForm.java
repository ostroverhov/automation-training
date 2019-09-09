package app.form;

import framework.elements.Button;
import framework.elements.DropDownList;
import framework.elements.Panel;

public class ValidateBirthdayForm {
    private String locate = " on ValidateBirthdayForm";

    private String yearAgeLocator = "//option[contains(text(),'%s')]";
    private String viewPageButtonLocator = "//a[@class='btnv6_blue_hoverfade btn_medium']";
    private String panelAgeLocator = "//div[@id='app_agegate']";

    private Button buttonVievPage = new Button(viewPageButtonLocator, "ButtonViewPage"  + locate);
    private Panel panelAge = new Panel(panelAgeLocator, "PanelAge" + locate);

    private DropDownList getDropDownList(int year){
        return new DropDownList((String.format(yearAgeLocator, year)), "DropDownList" + locate);
    }

    public void inputAge(int year){
        getDropDownList(year).clickElement();
    }

    public void clickButtonVievPage(){
        buttonVievPage.clickElement();
    }

    public boolean panelAgeIsDispl(){
        return panelAge.isDispl();
    }
}
