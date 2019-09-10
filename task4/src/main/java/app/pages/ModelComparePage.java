package app.pages;

import app.form.CompareForm;
import app.form.ComparePanel;

public class ModelComparePage {
    private ComparePanel comparePanel = new ComparePanel();
    private CompareForm compareForm = new CompareForm();

    public ComparePanel getComparePanel() {
        return comparePanel;
    }

    public CompareForm getCompareForm() {
        return compareForm;
    }
}
