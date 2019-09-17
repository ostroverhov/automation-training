package app.form;

import framework.elements.Button;
import framework.elements.DropDownMenu;
import org.openqa.selenium.By;

public class CompareForm {
    private String locate = " on CompareForm";

    private Button buttonStartCompare = new Button(By.xpath("//button[@class='done-button']"), "button start compare" + locate);
    private Button buttonDone = new Button(By.xpath("//button[@class='modal-button']"), "button done" + locate);

    private DropDownMenu dropDownMake = new DropDownMenu(By.xpath("//select[@id='make-dropdown']"), "dropDownMenu of Maker" + locate);
    private DropDownMenu dropDownModel = new DropDownMenu(By.xpath("//select[@id='model-dropdown']"), "dropDownMenu of model" + locate);
    private DropDownMenu dropDownYear = new DropDownMenu(By.xpath("//select[@id='year-dropdown']"), "dropDownMenu of year" + locate);

//    private DropDownMenu dropDownMake(String make) {
//        return new DropDownMenu(By.xpath(String.format("//select[@id='make-dropdown']//option[contains(text(),'%s')]", make)), "dropDownMenu of Maker" + locate);
//    }
//
//    private DropDownMenu dropDownModel(String model) {
//        return new DropDownMenu(By.xpath(String.format("//select[@id='model-dropdown']//option[contains(text(),'%s')]", model)), "dropDownMenu of model" + locate);
//    }
//
//    private DropDownMenu dropDownYear(String year) {
//        return new DropDownMenu(By.xpath(String.format("//select[@id='year-dropdown']//option[contains(text(),'%s')]", year)), "dropDownMenu of year" + locate);
//    }

    public void selectCar(String make, String model, String year) {
        dropDownMake.clickSelectElement(make);
        dropDownModel.clickSelectElement(model);
        dropDownYear.clickSelectElement(year);
    }

//    public void clickModel(String model) {
//        dropDownModel.clickSelectElement(model);
//    }
//
//    public void clickYear(String year) {
//        dropDownYear.clickSelectElement(year);
//    }

    public void clickButtonStartCompare() {
        buttonStartCompare.clickElement();
    }

    public boolean isDisplayedButtonStartCompare() {
        return buttonStartCompare.isDisplayedElement();
    }

    public void clickButtonDone() {
        buttonDone.clickElement();
    }
}
