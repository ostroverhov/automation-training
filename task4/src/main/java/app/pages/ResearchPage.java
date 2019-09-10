package app.pages;

import app.form.ResearchForm;
import app.form.ToolsForm;

public class ResearchPage {
    private ResearchForm researchForm = new ResearchForm();
    private ToolsForm toolsForm = new ToolsForm();

    public ResearchForm getResearchForm() {
        return researchForm;
    }

    public ToolsForm getToolsForm() {
        return toolsForm;
    }
}
