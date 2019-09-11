package app.form;

import framework.elements.Button;
import framework.elements.DropDownMenu;
import framework.utils.RandomElements;

public class ResearchForm {
    private String locate = " on ResearchForm";
    private String dropDownMakeLocator = "//select[@name='makeId']//option";
    private String dropDownModelLocator = "//select[@name='modelId']//option";
    private String dropDownYearLocator = "//select[@name='year']//option";
    private String buttonSearchLocator = "//input[@class='_3iP3L']";
    private int randomMake;
    private int randomModel;
    private int randomYear;

    private DropDownMenu dropDownMake = new DropDownMenu(dropDownMakeLocator, "dropDownMenu of Maker" + locate);
    private DropDownMenu dropDownModel = new DropDownMenu(dropDownModelLocator, "dropDownMenu of model" + locate);
    private DropDownMenu dropDownYear = new DropDownMenu(dropDownYearLocator, "dropDownMenu of year" + locate);
    private Button buttonResearch = new Button(buttonSearchLocator, "button research" + locate);

    public void getNumberRandomMake() {
        randomMake = RandomElements.getRandom(dropDownMake.getElements().size());
    }

    public void clickRandomMake() {
        dropDownMake.clickRandom(randomMake);
    }

    public String getTextRandomMake() {
        return dropDownMake.getTextRandom(randomMake);
    }

    public void getNumberRandomModel() {
        randomModel = RandomElements.getRandom(dropDownModel.getElements().size());
    }

    public void clickRandomModel() {
        dropDownModel.clickRandom(randomModel);
    }

    public String getTextRandomModel() {
        return dropDownModel.getTextRandom(randomModel);
    }

    public void getNumberRandomYear() {
        randomYear = RandomElements.getRandom(dropDownYear.getElements().size());
    }

    public void clickRandomYear() {
        dropDownYear.clickRandom(randomYear);
    }

    public String getTextRandomYear() {
        return dropDownYear.getTextRandom(randomYear);
    }

    public void clickButtonResearch() {
        buttonResearch.clickElement();
    }

    public void selectCar() {
        getNumberRandomMake();
        clickRandomMake();
        getNumberRandomModel();
        clickRandomModel();
        getNumberRandomYear();
        clickRandomYear();
    }
}
