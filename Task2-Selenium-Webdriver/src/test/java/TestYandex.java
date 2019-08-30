import application.*;
import browser.Browser;
import browser.IllegalBrowserNameException;
import framework.Reader;
import framework.RandomAndRegexpUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static framework.Reader.getParametr;

public class TestYandex {

    WebDriver driver = Browser.initBrowser();
    String URL = getParametr("URL");
    int timeout = Integer.parseInt(getParametr("timeout"));

    public TestYandex() throws IllegalBrowserNameException {
    }

    @BeforeMethod
    public void setUp() {
        Browser.setTimeToWait(driver, timeout);
        Browser.setMaxSizeWindow(driver);
        Browser.setURL(driver, URL);
    }

    @AfterMethod
    public void tearDown() {
        Browser.closeBrowser(driver);
    }

    @Test
    @Parameters(value = {"login", "password"})
    public void testYandexMarket(String login, String password) throws IOException {
        MainPage mainPage = new MainPage();
        String tab = driver.getWindowHandle();
        Assert.assertTrue(mainPage.buttonLoginIsDisplayed(), "кнопка войти отсутствует, главная страница  маркета не открыта");
        Assert.assertTrue(RandomAndRegexpUtils.regexpHandler("маркет", mainPage.getMainPageLogoText()), "на странице не соответствует название логотипа, не верная страница");

        mainPage.clickButtonLogin();
        Browser.switchTab(driver);
        InputLoginPage inputLoginPage = new InputLoginPage();
        inputLoginPage.setLogin(login);
        InputPasswordPage inputPasswordPage = new InputPasswordPage();
        inputPasswordPage.setPassword(password);

        driver.switchTo().window(tab);
        MainPageLogin mainPageLogin = new MainPageLogin();
        Assert.assertTrue(mainPageLogin.logoUserIsDisplayed(), "не удалось залогиниться");

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.getArrayPopularCategory();
        int random = RandomAndRegexpUtils.getRandom(catalogPage.getSizeCatalogPopularCategory());
        String nameRandomCategory = catalogPage.getNameCategory(random);
        catalogPage.clickCategory(random);
        RandomCategoryPage randomCategoryPage = new RandomCategoryPage();
        String namePage = randomCategoryPage.getNamePage();
        Assert.assertTrue(RandomAndRegexpUtils.regexpHandler(nameRandomCategory, namePage), "название страницы не соответствует названию выбранной категории");

        catalogPage.clickMainPageLogin();
        List<String> allCategory = mainPageLogin.getWriteAllCategories();
        List<String> popularCategory = catalogPage.getListPopularCategory();
        Assert.assertEquals(Reader.readCategory("category.csv"), allCategory, "записанные категории не соответствуют представленным на странице");
        Assert.assertTrue(allCategory.containsAll(popularCategory), "\"все категории\" не соответствуют \"популярным\"");

        mainPageLogin.clickLogout();
        Assert.assertTrue(mainPage.buttonLoginIsDisplayed(), "кнопка войти отсутствует, выйти из профиля не удалось");
    }
}
