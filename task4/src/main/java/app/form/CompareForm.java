package app.form;

import app.pages.BasePage;
import framework.elements.Button;
import framework.elements.DropDownMenu;
import org.openqa.selenium.By;

public class CompareForm extends BasePage {

    private Button buttonStartCompare = new Button(By.xpath("//button[@class='done-button']"), getFullElementName("button start compare"));
    private Button buttonDone = new Button(By.xpath("//button[@class='modal-button']"), getFullElementName("button done"));

    private DropDownMenu dropDownMake = new DropDownMenu(By.id("make-dropdown"), getFullElementName("dropDownMenu of Maker"));
    private DropDownMenu dropDownModel = new DropDownMenu(By.id("model-dropdown"), getFullElementName("dropDownMenu of model"));
    private DropDownMenu dropDownYear = new DropDownMenu(By.id("year-dropdown"), getFullElementName("dropDownMenu of year"));

    public CompareForm() {
        super("Compare form", By.xpath("//button[@class='done-button']"));
    }

    public void selectCar(String make, String model, String year) {
        dropDownMake.clickSelectElement(make);
        dropDownModel.clickSelectElement(model);
        dropDownYear.clickSelectElement(year);
    }

    public void clickButtonStartCompare() {
        buttonStartCompare.clickElement();
    }

    public void clickButtonDone() {
        buttonDone.clickElement();
    }
}
