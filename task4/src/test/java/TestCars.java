import app.Car;
import app.pages.*;
import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCars extends CommonConditions {

    @Test
    public void testCars() {
        MyLogger.step("Open and check main page");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.getTopMenu().isDisplButtonLogoMainPage(), "Main page not found");

        MyLogger.step("Create first car");
        Car firstCar = addCar();

        MyLogger.step("Go to main page");
        BrowserFactory.goToMainPage(URL);
        Assert.assertTrue(mainPage.getTopMenu().isDisplButtonLogoMainPage(), "Main page not found");

        MyLogger.step("Create second car");
        Car secondCar = addCar();

        MyLogger.step("Go to research page");
        CompareTrimPage compareTrimPage = new CompareTrimPage();
        compareTrimPage.getTopMenu().clickOnButtonTopMenu("Research");
        ResearchPage researchPage = new ResearchPage();
        Assert.assertTrue(researchPage.getToolsForm().isDisplToolsForm(), "Page research not found");

        MyLogger.step("Click side-by-side comparisons");
        researchPage.getToolsForm().clickOnButtonToolsForm("Side-by-side Comparisons");
        CompareSideBySideCarsPage compareSideBySideCarsPage = new CompareSideBySideCarsPage();
        Assert.assertTrue(compareSideBySideCarsPage.getCompareForm().isDisplayedButtonStartCompare(), "Page side-by-side comparisons not found");

        MyLogger.step("Select first car and go to model compare page");
        compareSideBySideCarsPage.getCompareForm().clickMake(firstCar.getMake());
        compareSideBySideCarsPage.getCompareForm().clickModel(firstCar.getModel());
        compareSideBySideCarsPage.getCompareForm().clickYear(firstCar.getYear());
        compareSideBySideCarsPage.getCompareForm().clickButtonStartCompare();
        ModelComparePage modelComparePage = new ModelComparePage();
        Assert.assertTrue(modelComparePage.getComparePanel().isDisplayedButtonAddAnotherCar(), "Model compare page not found");

        Assert.assertTrue(modelComparePage.getComparePanel().getTextFromPanelFirstCar().contains(firstCar.getMake()), "make not match");
        Assert.assertTrue(modelComparePage.getComparePanel().getTextFromPanelFirstCar().contains(firstCar.getModel()), "model not match");
        Assert.assertTrue(modelComparePage.getComparePanel().getTextFromPanelFirstCar().contains(firstCar.getYear()), "year not match");

        MyLogger.step("Add second car to model compare page");
        modelComparePage.getComparePanel().clickOnButtonAddAnotherCar();
        modelComparePage.getCompareForm().clickMake(secondCar.getMake());
        modelComparePage.getCompareForm().clickModel(secondCar.getModel());
        modelComparePage.getCompareForm().clickYear(secondCar.getYear());
        modelComparePage.getCompareForm().clickButtonDone();

        Assert.assertTrue(modelComparePage.getComparePanel().getTextFromPanelSecondCar().contains(secondCar.getMake()), "make not match");
        Assert.assertTrue(modelComparePage.getComparePanel().getTextFromPanelSecondCar().contains(secondCar.getModel()), "model not match");
        Assert.assertTrue(modelComparePage.getComparePanel().getTextFromPanelSecondCar().contains(secondCar.getYear()), "year not match");

        MyLogger.step("Compare engine and transmission of cars");
        Assert.assertTrue(modelComparePage.getComparePanel().getTextFromPanelFirstCarEngine().contains(firstCar.getEngine()), "engine first car not match");
        Assert.assertTrue(modelComparePage.getComparePanel().getTextFromPanelSecondCarEngine().contains(secondCar.getEngine()), "engine second car not match");
        Assert.assertTrue(modelComparePage.getComparePanel().getTextFromPanelFirstCarTrans().contains(firstCar.getTrans()), "trans first car not match");
        Assert.assertTrue(modelComparePage.getComparePanel().getTextFromPanelSecondCarTrans().contains(secondCar.getTrans()), "trans second car not match");
    }

    private Car addCar() {
        MainPage mainPage = new MainPage();
        MyLogger.step("Go to research page");
        mainPage.getTopMenu().clickOnButtonTopMenuMain("Research");
        ResearchPage researchPage = new ResearchPage();
        Assert.assertTrue(researchPage.getToolsForm().isDisplToolsForm(), "Page research not found");

        MyLogger.step("Select random parametr and create car. Go to car's page");
        Car car = new Car();
        researchPage.getResearchForm().selectCar();
        car.setMake(researchPage.getResearchForm().getTextRandomMake());
        car.setModel(researchPage.getResearchForm().getTextRandomModel());
        car.setYear(researchPage.getResearchForm().getTextRandomYear());
        researchPage.getResearchForm().clickButtonResearch();
        CarPage carPage = new CarPage();
        for (int i = 0; i < 3; i++) {
            if (!carPage.getInfoSection().buttonIsPresent()) {
                carPage.getTopMenu().clickOnButtonTopMenu("Research");
                researchPage.getResearchForm().selectCar();
                car.setMake(researchPage.getResearchForm().getTextRandomMake());
                car.setModel(researchPage.getResearchForm().getTextRandomModel());
                car.setYear(researchPage.getResearchForm().getTextRandomYear());
                researchPage.getResearchForm().clickButtonResearch();
            }
            if (carPage.getInfoSection().buttonIsPresent()) {
                break;
            }
        }
        Assert.assertTrue(carPage.getInfoSection().getTextPanelInfoCar().contains(car.getMake()), "make not match");
        Assert.assertTrue(carPage.getInfoSection().getTextPanelInfoCar().contains(car.getModel()), "model not match");
        Assert.assertTrue(carPage.getInfoSection().getTextPanelInfoCar().contains(car.getYear()), "year not match");

        MyLogger.step("Go to page compare trim");
        carPage.getInfoSection().clickOnButtonCompareTrim();
        CompareTrimPage compareTrimPage = new CompareTrimPage();
        Assert.assertTrue(compareTrimPage.getTrimCard().isDisplPanelEngine(), "Page compare trim not found");
        car.setEngine(compareTrimPage.getTrimCard().getTextPanelEngine());
        car.setTrans(compareTrimPage.getTrimCard().getTextPanelTrans());
        return car;
    }
}
