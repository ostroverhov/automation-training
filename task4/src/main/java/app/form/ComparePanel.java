package app.form;

import framework.elements.Button;
import framework.elements.Panel;
import framework.utils.Wait;
import org.openqa.selenium.By;

public class ComparePanel {
    private String locate = " on Compare Form";

    private Button buttonAddAnotherCar = new Button(By.xpath("//div[@id='icon-div']"), " button" + locate);
    private Panel panelFirstCar = new Panel(By.xpath("//cars-compare-compare-info[@format='research-car-mmyt']//span[1]"), "panel first car" + locate);
    private Panel panelSecondCar = new Panel(By.xpath("//cars-compare-compare-info[@format='research-car-mmyt']//span[2]"), "panel second car" + locate);
    private Panel panelFirstCarEngine = new Panel(By.xpath("//cars-compare-compare-info[@header='Engine']//span[1]"), "panel first car engine" + locate);
    private Panel panelSecondCarEngine = new Panel(By.xpath("//cars-compare-compare-info[@header='Engine']//span[2]"), "panel second car engine" + locate);
    private Panel panelFirstCarTrans = new Panel(By.xpath("//cars-compare-compare-info[@header='Transmission']//span[1]"), "panel first car trans" + locate);
    private Panel panelSecondCarTrans = new Panel(By.xpath("//cars-compare-compare-info[@header='Transmission']//span[2]"), "panel second car trans" + locate);

    public void clickOnButtonAddAnotherCar() {
        buttonAddAnotherCar.clickElement();
    }

    public boolean isDisplayedButtonAddAnotherCar() {
        return Wait.waitElementToBeClickable(buttonAddAnotherCar.getElement()).isDisplayed();
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
