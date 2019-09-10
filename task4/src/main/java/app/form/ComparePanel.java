package app.form;

import framework.elements.Button;
import framework.elements.Panel;
import framework.utils.Wait;

public class ComparePanel {//cars-compare-compare-info[@header='Engine']//span
    private String locate = " on Compare Form";
    private String buttonAddAnotherCar = "//a[@id='add-from-your-favorite-cars-link']";
    private String panelFirstCar = "//cars-compare-compare-info[@format='research-car-mmyt']//span[1]";
    private String panelSecondCar = "//cars-compare-compare-info[@format='research-car-mmyt']//span[2]";
    private String panelFirstCarEngine= "//cars-compare-compare-info[@header='Engine']//span[1]"; //add class
    private String panelSecondCarEngine = "//cars-compare-compare-info[@header='Engine']//span[2]";
    private String panelFirstCarTrans = "//cars-compare-compare-info[@header='Transmission']//span[1]";
    private String panelSecondCarTrans = "//cars-compare-compare-info[@header='Transmission']//span[2]";

    private Button getButtonAddAnotherCar() {
        return new Button(buttonAddAnotherCar, " button" + locate);
    }

    private Panel getPanelFirstCar() {
        return new Panel(panelFirstCar, "panel first car" + locate);
    }

    private Panel getPanelSecondCar() {
        return new Panel(panelSecondCar, "panel second car" + locate);
    }

    private Panel getPanelFirstCarEngine() {
        return new Panel(panelFirstCarEngine, "panel first car engine" + locate);
    }

    private Panel getPanelSecondCarEngine() {
        return new Panel(panelSecondCarEngine, "panel second car engine" + locate);
    }

    private Panel getPanelFirstCarTrans() {
        return new Panel(panelFirstCarTrans, "panel first car trans" + locate);
    }

    private Panel getPanelSecondCarTrans() {
        return new Panel(panelSecondCarTrans, "panel second car trans" + locate);
    }

    public void clickOnButtonAddAnotherCar() {
        getButtonAddAnotherCar().clickElement();
    }

    public boolean isDisplButtonAddAnotherCar(){
        return Wait.waitElements(getButtonAddAnotherCar().getElement()).isDisplayed();
    }

    public String getTextFromPanelFirstCar() {
        return getPanelFirstCar().getTextFromElement();
    }

    public String getTextFromPanelSecondCar() {
        return getPanelSecondCar().getTextFromElement();
    }

    public String getTextFromPanelFirstCarEngine() {
        return getPanelFirstCarEngine().getTextFromElement();
    }

    public String getTextFromPanelSecondCarEngine() {
        return getPanelSecondCarEngine().getTextFromElement();
    }

    public String getTextFromPanelFirstCarTrans() {
        return getPanelFirstCarTrans().getTextFromElement();
    }

    public String getTextFromPanelSecondCarTrans() {
        return getPanelSecondCarTrans().getTextFromElement();
    }

}
