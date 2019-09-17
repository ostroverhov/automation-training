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

    public void selectCar(String make, String model, String year) {
        dropDownMake.clickSelectElement(make);
        dropDownModel.clickSelectElement(model);
        dropDownYear.clickSelectElement(year);
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
