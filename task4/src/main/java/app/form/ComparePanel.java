package app.form;

import framework.elements.Button;
import framework.elements.Panel;
import framework.utils.Wait;

public class ComparePanel {
    private String locate = " on Compare Form";
    private String buttonAddAnotherCarLocator = "//a[@id='add-from-your-favorite-cars-link']";
    private String panelFirstCarLocator = "//cars-compare-compare-info[@format='research-car-mmyt']//span[1]";
    private String panelSecondCarLocator = "//cars-compare-compare-info[@format='research-car-mmyt']//span[2]";
    private String panelFirstCarEngineLocator = "//cars-compare-compare-info[@header='Engine']//span[1]"; //add class
    private String panelSecondCarEngineLocator = "//cars-compare-compare-info[@header='Engine']//span[2]";
    private String panelFirstCarTransLocator = "//cars-compare-compare-info[@header='Transmission']//span[1]";
    private String panelSecondCarTransLocator = "//cars-compare-compare-info[@header='Transmission']//span[2]";

    private Button buttonAddAnotherCar = new Button(buttonAddAnotherCarLocator, " button" + locate);
    private Panel panelFirstCar = new Panel(panelFirstCarLocator, "panel first car" + locate);
    private Panel panelSecondCar = new Panel(panelSecondCarLocator, "panel second car" + locate);
    private Panel panelFirstCarEngine = new Panel(panelFirstCarEngineLocator, "panel first car engine" + locate);
    private Panel panelSecondCarEngine = new Panel(panelSecondCarEngineLocator, "panel second car engine" + locate);
    private Panel panelFirstCarTrans = new Panel(panelFirstCarTransLocator, "panel first car trans" + locate);
    private Panel panelSecondCarTrans = new Panel(panelSecondCarTransLocator, "panel second car trans" + locate);

    public void clickOnButtonAddAnotherCar() {
        buttonAddAnotherCar.clickElement();
    }

    public boolean isDisplayedButtonAddAnotherCar() {
        return Wait.waitElements(buttonAddAnotherCar.getElement()).isDisplayed();
    }

    public String getTextFromPanelFirstCar() {
        return panelFirstCar.getTextFromElement();
    }

    public String getTextFromPanelSecondCar() {
        return panelSecondCar.getTextFromElement();
    }

    public String getTextFromPanelFirstCarEngine() {
        return panelFirstCarEngine.getTextFromElement();
    }

    public String getTextFromPanelSecondCarEngine() {
        return panelSecondCarEngine.getTextFromElement();
    }

    public String getTextFromPanelFirstCarTrans() {
        return panelFirstCarTrans.getTextFromElement();
    }

    public String getTextFromPanelSecondCarTrans() {
        return panelSecondCarTrans.getTextFromElement();
    }

}
