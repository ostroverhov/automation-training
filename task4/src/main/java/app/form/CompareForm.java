package app.form;

import framework.elements.Button;
import framework.elements.DropDownMenu;
import org.openqa.selenium.By;

public class CompareForm {
    private String locate = " on CompareForm";

    private Button buttonStartCompare = new Button(By.xpath("//button[@class='done-button']"), "button start compare" + locate);
    private Button buttonDone = new Button(By.xpath("//button[@class='modal-button']"), "button done" + locate);

    private DropDownMenu getDropDownMake(String make) {
        return new DropDownMenu(By.xpath(String.format("//select[@id='make-dropdown']//option[contains(text(),'%s')]", make)), "dropDownMenu of Maker" + locate);
    }

    private DropDownMenu getDropDownModel(String model) {
        return new DropDownMenu(By.xpath(String.format("//select[@id='model-dropdown']//option[contains(text(),'%s')]", model)), "dropDownMenu of model" + locate);
    }

    private DropDownMenu getDropDownYear(String year) {
        return new DropDownMenu(By.xpath(String.format("//select[@id='year-dropdown']//option[contains(text(),'%s')]", year)), "dropDownMenu of year" + locate);
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
        buttonDone.clickElement();
    }
}
