import app.form.CompareForm;
import app.form.ComparePanel;
import app.form.TrimCard;
import app.models.Car;
import app.pages.*;
import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static app.form.MenuHeaderItem.RESEARCH;


public class TestCars extends BaseTest {
    private static final int iteration = 3;

    @Test
    public void testCars() {
        MyLogger.step("Open and check main page");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.getTopMenu().isDisplButtonLogoMainPage(), "Main page not found");

        MyLogger.step("Create first car");
        Car firstCar = addCar();

        MyLogger.step("Go to main page");
        BrowserFactory.setUrl(URL);
        Assert.assertTrue(mainPage.getTopMenu().isDisplButtonLogoMainPage(), "Main page not found");

        MyLogger.step("Create second car");
        Car secondCar = addCar();

        MyLogger.step("Go to research page");
        CompareTrimPage compareTrimPage = new CompareTrimPage();
        compareTrimPage.getTopMenu().clickOnButtonTopMenu(RESEARCH);
        ResearchPage researchPage = new ResearchPage();
        Assert.assertTrue(researchPage.getToolsForm().isDisplToolsForm(), "Page research not found");

        MyLogger.step("Click side-by-side comparisons");
        researchPage.getToolsForm().clickOnButtonToolsForm("Side-by-side Comparisons");
        CompareSideBySideCarsPage compareSideBySideCarsPage = new CompareSideBySideCarsPage();
        CompareForm compareForm = compareSideBySideCarsPage.getCompareForm();
        Assert.assertTrue(compareForm.isDisplayedButtonStartCompare(), "Page side-by-side comparisons not found");

        MyLogger.step("Select first car and go to model compare page");
        compareForm.selectCar(firstCar.getMake(), firstCar.getModel(), firstCar.getYear());
        compareForm.clickButtonStartCompare();
        ModelComparePage modelComparePage = new ModelComparePage();
        ComparePanel comparePanel = modelComparePage.getComparePanel();
        Assert.assertTrue(comparePanel.isDisplayedButtonAddAnotherCar(), "Model compare page not found");

        String textFromPanelFirstCar = comparePanel.getTextFromPanelFirstCar();
        assertCarParameters(textFromPanelFirstCar, firstCar.getMake(), "make");
        assertCarParameters(textFromPanelFirstCar, firstCar.getModel(), "model");
        assertCarParameters(textFromPanelFirstCar, firstCar.getYear(), "year");

        MyLogger.step("Add second car to model compare page");
        comparePanel.clickOnButtonAddAnotherCar();
        CompareForm compareFormFromModelComparePage = modelComparePage.getCompareForm();
        compareFormFromModelComparePage.selectCar(secondCar.getMake(), secondCar.getModel(), secondCar.getYear());
        compareFormFromModelComparePage.clickButtonDone();

        String textFromPanelSecondCar = comparePanel.getTextFromPanelSecondCar();
        assertCarParameters(textFromPanelSecondCar, secondCar.getMake(), "make");
        assertCarParameters(textFromPanelSecondCar, secondCar.getModel(), "model");
        assertCarParameters(textFromPanelSecondCar, secondCar.getYear(), "year");

        MyLogger.step("Compare engine and transmission of cars");
        assertCarParameters(comparePanel.getTextFromPanelFirstCarEngine(), firstCar.getEngine(), "engine first car");
        assertCarParameters(comparePanel.getTextFromPanelSecondCarEngine(), secondCar.getEngine(), "engine second car");
        assertCarParameters(comparePanel.getTextFromPanelFirstCarTransmission(), firstCar.getTransmission(), "trans first car");
        assertCarParameters(comparePanel.getTextFromPanelSecondCarTransmission(), secondCar.getTransmission(), "trans second car");
    }

    private Car addCar() {
        MainPage mainPage = new MainPage();
        MyLogger.step("Go to research page");
        mainPage.getTopMenu().clickOnButtonTopMenuMain(RESEARCH);
        ResearchPage researchPage = new ResearchPage();
        Assert.assertTrue(researchPage.getToolsForm().isDisplToolsForm(), "Page research not found");

        MyLogger.step("Select random parameter and create car. Go to car's page");
        Car car = researchPage.getResearchForm().selectRandomCar();
        researchPage.getResearchForm().clickButtonResearch();
        CarPage carPage = new CarPage();
        for (int i = 0; i < iteration; i++) {
            if (!carPage.getInfoSection().buttonIsPresent()) {
                carPage.getTopMenu().clickOnButtonTopMenu(RESEARCH);
                car = researchPage.getResearchForm().selectRandomCar();
                researchPage.getResearchForm().clickButtonResearch();
            }
            if (carPage.getInfoSection().buttonIsPresent()) {
                break;
            }
        }
        String textPanelInfoCar = carPage.getInfoSection().getTextPanelInfoCar();
        assertCarParameters(textPanelInfoCar, car.getMake(), "make");
        assertCarParameters(textPanelInfoCar, car.getModel(), "model");
        assertCarParameters(textPanelInfoCar, car.getYear(), "year");

        MyLogger.step("Go to page compare trim");
        carPage.getInfoSection().clickOnButtonCompareTrim();
        CompareTrimPage compareTrimPage = new CompareTrimPage();
        TrimCard trimCard = compareTrimPage.getTrimCard();
        Assert.assertTrue(trimCard.isDisplPanelEngine(), "Page compare trim not found");
        car.setEngine(trimCard.getTextPanelEngine());
        car.setTransmission(trimCard.getTextPanelTrans());
        return car;
    }

    private void assertCarParameters(String carParameterFromPage, String carParameter, String nameCarParameter) {
        Assert.assertTrue(carParameterFromPage.contains(carParameter), nameCarParameter + " not match");
    }
}