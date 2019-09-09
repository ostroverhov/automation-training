package app.pages;

import app.form.ValidateBirthdayForm;
import framework.utils.MyLogger;
import org.openqa.selenium.NoSuchElementException;

public class ValidateBirthdayPage {

    private ValidateBirthdayForm validateBirthdayForm = new ValidateBirthdayForm();

    public static void inputAge(int year){
        try {
            ValidateBirthdayPage validateBirthdayPage = new ValidateBirthdayPage();
            if (validateBirthdayPage.validateBirthdayForm.panelAgeIsDispl()){
                validateBirthdayPage.validateBirthdayForm.inputAge(year);
                validateBirthdayPage.validateBirthdayForm.clickButtonVievPage();
            }
        } catch (NoSuchElementException ignored) {
            MyLogger.warn("Page with validation age is absent");
        }
    }
}
