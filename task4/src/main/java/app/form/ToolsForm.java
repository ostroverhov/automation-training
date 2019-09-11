package app.form;

import framework.elements.Button;
import framework.elements.Panel;

public class ToolsForm {
    private String locate = " on ToolsForm";
    private String buttonToolsFormLocator = "//h4[contains(text(),'%s')]";
    private String toolsFormLocator = "//div[@class='_1jPxd']";

    private Panel panelToolsForm = new Panel(toolsFormLocator, "toolsForm" + locate);

    private Button getButtonToolsForm(String nameButton) {
        return new Button(String.format(buttonToolsFormLocator, nameButton), nameButton + " button" + locate);
    }

    public void clickOnButtonToolsForm(String nameButton) {
        getButtonToolsForm(nameButton).clickElement();
    }

    public boolean isDisplToolsForm(){
        return panelToolsForm.isDisplayedElement();
    }
}
