package app.form;

import app.models.Car;
import framework.elements.Button;
import framework.elements.DropDownMenu;
import framework.utils.RandomElements;
import org.openqa.selenium.By;

public class ResearchForm {
    private String locate = " on ResearchForm";

    private DropDownMenu dropDownMake = new DropDownMenu(By.xpath("//select[@class='_2jV43 _1vzbb']//option"), "dropDownMenu of Maker" + locate);//todo change locators
    private DropDownMenu dropDownModel = new DropDownMenu(By.xpath("//select[@class='_2jV43 _1AnAd']//option"), "dropDownMenu of model" + locate);
    private DropDownMenu dropDownYear = new DropDownMenu(By.xpath("//select[@class='_2jV43 ZM4eE']//option"), "dropDownMenu of year" + locate);
    private Button buttonResearch = new Button(By.xpath("//input[@class='_3iP3L']"), "button research" + locate);

    public void clickButtonResearch() {
        buttonResearch.clickElement();
    }

    public Car selectCar() {
        Car car = new Car();
        int randomMake = RandomElements.getRandom(dropDownMake.getElements().size());
        dropDownMake.clickSelectElement(randomMake);
        car.setMake(dropDownMake.getTextSelectElement(randomMake));
        int randomModel = RandomElements.getRandom(dropDownModel.getElements().size());
        dropDownModel.clickSelectElement(randomModel);
        car.setModel(dropDownModel.getTextSelectElement(randomModel));
        int randomYear = RandomElements.getRandom(dropDownYear.getElements().size());
        dropDownYear.clickSelectElement(randomYear);
        car.setYear(dropDownYear.getTextSelectElement(randomYear));
        return car;
    }
}
