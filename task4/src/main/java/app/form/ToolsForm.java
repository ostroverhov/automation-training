package app.form;

import framework.elements.Button;
import framework.elements.Panel;
import org.openqa.selenium.By;

public class ToolsForm {
    private String locate = " on ToolsForm";

    private Panel panelToolsForm = new Panel(By.xpath("//div[@class='_1jPxd']"), "toolsForm" + locate);

    private Button getButtonToolsForm(String nameButton) {
        return new Button(By.xpath(String.format("//h4[contains(text(),'%s')]", nameButton)), nameButton + " button" + locate);
    }

    public void clickOnButtonToolsForm(String nameButton) {
        getButtonToolsForm(nameButton).clickElement();
    }

    public boolean isDisplToolsForm(){
        return panelToolsForm.isDisplayedElement();
    }
}
