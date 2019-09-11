package app.form;

import framework.elements.Button;
import framework.elements.DropDownMenu;

public class CompareForm {
    private String locate = " on CompareForm";
    private String dropDownMakeLocator = "//select[@id='make-dropdown']//option[contains(text(),'%s')]";
    private String dropDownModelLocator = "//select[@id='model-dropdown']//option[contains(text(),'%s')]";
    private String dropDownYearLocator = "//select[@id='year-dropdown']//option[contains(text(),'%s')]";
    private String buttonStartCompareLocator = "//button[@class='done-button']";
    private String buttonDoneLocator = "//button[@class='modal-button']";

    private Button buttonStartCompare = new Button(buttonStartCompareLocator, "button start compare" + locate);

    private DropDownMenu getDropDownMake(String make) {
        return new DropDownMenu(String.format(dropDownMakeLocator, make), "dropDownMenu of Maker" + locate);
    }

    private DropDownMenu getDropDownModel(String model) {
        return new DropDownMenu(String.format(dropDownModelLocator, model), "dropDownMenu of model" + locate);
    }

    private DropDownMenu getDropDownYear(String year) {
        return new DropDownMenu(String.format(dropDownYearLocator, year), "dropDownMenu of year" + locate);
    }

    private Button getButtonDone() {
        return new Button(buttonDoneLocator, "button done" + locate);
    }

    public void clickMake(String make) {
        getDropDownMake(make).clickElement();
    }

    public void clickModel(String model) {
        getDropDownModel(model).clickElement();
    }

    public void clickYear(String year) {
        getDropDownYear(year).clickElement();
    }

    public void clickButtonStartCompare() {
        buttonStartCompare.clickElement();
    }

    public boolean isDisplayedButtonStartCompare() {
        return buttonStartCompare.isDisplayedElement();
    }

    public void clickButtonDone() {
        getButtonDone().clickElement();
    }
}
