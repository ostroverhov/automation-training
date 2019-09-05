package app.pages;

import app.form.ValidateBirthdayForm;
import org.openqa.selenium.NoSuchElementException;

public class ValidateBirthdayPage {

    public ValidateBirthdayForm validateBirthdayForm = new ValidateBirthdayForm();

    public static void inputAge(){
        try {
            ValidateBirthdayPage validateBirthdayPage = new ValidateBirthdayPage();
            if (validateBirthdayPage.validateBirthdayForm.panelAgeIsDispl()){
                validateBirthdayPage.validateBirthdayForm.inputAge();
                validateBirthdayPage.validateBirthdayForm.clickButtonVievPage();
            }
        } catch (NoSuchElementException ignored) {

        }
    }
}
