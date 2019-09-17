package app.form;

import app.models.Car;
import framework.elements.Button;
import framework.elements.DropDownMenu;
import org.openqa.selenium.By;

public class ResearchForm {
    private String locate = " on ResearchForm";

    private DropDownMenu dropDownMake = new DropDownMenu(By.xpath("//select[@class='_2jV43 _1vzbb']"), "dropDownMenu of Maker" + locate);//todo change locators
    private DropDownMenu dropDownModel = new DropDownMenu(By.xpath("//select[@class='_2jV43 _1AnAd']"), "dropDownMenu of model" + locate);
    private DropDownMenu dropDownYear = new DropDownMenu(By.xpath("//select[@class='_2jV43 ZM4eE']"), "dropDownMenu of year" + locate);
    private Button buttonResearch = new Button(By.xpath("//input[@class='_3iP3L']"), "button research" + locate);

    public void clickButtonResearch() {
        buttonResearch.clickElement();
    }

    public Car selectRandomCar() {
        Car car = new Car();
        String make = dropDownMake.getRandomElement();
        dropDownMake.clickSelectElement(make);
        car.setMake(make);
        String model = dropDownModel.getRandomElement();
        dropDownModel.clickSelectElement(model);
        car.setModel(model);
        String year = dropDownYear.getRandomElement();
        dropDownYear.clickSelectElement(year);
        car.setYear(year);
        return car;
    }
}
