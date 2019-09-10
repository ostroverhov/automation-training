package app.form;

import framework.elements.Button;
import framework.elements.DropDownMenu;
import framework.utils.RandomElements;
import org.openqa.selenium.WebElement;

public class ResearchForm {
    private String locate = " on ResearchForm";
    private String dropDownMakeLocator = "//select[@name='makeId']//option";
    private String dropDownModelLocator = "//select[@name='modelId']//option";
    private String dropDownYearLocator = "//select[@name='year']//option";
    private String buttonSearchLocator = "//input[@class='_3iP3L']";
    private int randomMake;
    private int randomModel;
    private int randomYear;

    private DropDownMenu getDropDownMake() {
        return new DropDownMenu(dropDownMakeLocator, "dropDownMenu of Maker" + locate);
    }

    private DropDownMenu getDropDownModel() {
        return new DropDownMenu(dropDownModelLocator, "dropDownMenu of model" + locate);
    }

    private DropDownMenu getDropDownYear() {
        return new DropDownMenu(dropDownYearLocator, "dropDownMenu of year" + locate);
    }

    private Button getButtonResearch() {
        return new Button(buttonSearchLocator, "button research" + locate);
    }

    public void getNumberRandomMake() {
        randomMake = RandomElements.getRandom(getDropDownMake().getElements().size());
    }

    public void clickRandomMake(){
        getDropDownMake().clickRandom(randomMake);
    }

    public String getTextRandomMake() {
        return getDropDownMake().getTextRandom(randomMake);
    }

    public void getNumberRandomModel() {
        randomModel = RandomElements.getRandom(getDropDownModel().getElements().size());
    }

    public void clickRandomModel(){
        getDropDownModel().clickRandom(randomModel);
    }

    public String getTextRandomModel(){
        return getDropDownModel().getTextRandom(randomModel);
    }

    public void getNumberRandomYear() {
        randomYear = RandomElements.getRandom(getDropDownYear().getElements().size());
    }

    public void clickRandomYear(){
        getDropDownYear().clickRandom(randomYear);
    }

    public String getTextRandomYear() {
        return getDropDownYear().getTextRandom(randomYear);
    }

    public void clickButtonResearch() {
        getButtonResearch().clickElement();
    }

    public void selectCar(){
        getNumberRandomMake();
        clickRandomMake();
        getNumberRandomModel();
        clickRandomModel();
        getNumberRandomYear();
        clickRandomYear();
    }
}
