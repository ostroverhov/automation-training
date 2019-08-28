import application.*;
import browser.Browser;
import browser.BrowserSingleton;
import browser.IllegalBrowserNameException;
import framework.Reader;
import framework.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TestYandex {

    WebDriver driver = Browser.initBrowser();
    String URL = Reader.getStringParametr("URL");
    String login = Reader.getStringParametr("login");
    String password = Reader.getStringParametr("password");
    int timeout = Reader.getIntParametr("timeout");

    public TestYandex() throws IOException, IllegalBrowserNameException {
    }

    @BeforeMethod
    public void setUp() {
        Browser.setTimeToWait(driver, timeout);
        Browser.setMaxSizeWindow(driver);
        Browser.setURL(driver, URL);
    }

    @AfterMethod
    public void tearDown(){
        Browser.closeBrowser(driver);
    }

    @Test
    public void testYandexMarket() throws IOException{
        MainPage mainPage = new MainPage(driver);
        String tab = driver.getWindowHandle();
        Assert.assertTrue(mainPage.getButtonLogin().isDisplayed(), "кнопка войти отсутствует, главная страница  маркета не открыта");
        Assert.assertTrue(Utils.regexpHandler("маркет", mainPage.getMainPageLogoText()), "на странице не соответствует название логотипа, не верная страница");

        mainPage.clickButtonLogin();
        Browser.switchTab(driver);
        InputLoginPage inputLoginPage = new InputLoginPage(driver);
        inputLoginPage.setLogin(login);
        InputPasswordPage inputPasswordPage = new InputPasswordPage(driver);
        inputPasswordPage.setPassword(password);

        driver.switchTo().window(tab);
        MainPageLogin mainPageLogin = new MainPageLogin(driver);
        Assert.assertTrue(mainPageLogin.getLogoUser(), "не удалось залогиниться");

        CatalogPage catalogPage = new CatalogPage(driver);
        List<WebElement> arrayPopularCategory = catalogPage.getArrayPopularCategory();
        int random = Utils.getRandom(arrayPopularCategory);
        String nameRandomCategory = catalogPage.getNameRandomcategory(arrayPopularCategory,random);
        catalogPage.clickRandomCategory(arrayPopularCategory, random);
        RandomCategoryPage randomCategoryPage = new RandomCategoryPage(driver);
        String namePage = randomCategoryPage.getNamePage();
        Assert.assertTrue(Utils.regexpHandler(nameRandomCategory, namePage), "название страницы не соответствует названию выбранной категории");

        catalogPage.clickMainPageLogin();
        List<String> allCategory = mainPageLogin.clickAllCategories();
        List<String> popularCategory = catalogPage.getListPopularCategory();
        Assert.assertEquals(Reader.readCategory("category.csv"), allCategory, "записанные категории не соответствуют представленным на странице");
        Assert.assertTrue(allCategory.containsAll(popularCategory), "\"все категории\" не соответствуют \"популярным\"");

        mainPageLogin.clickLogout();
        Assert.assertTrue(mainPage.getButtonLogin().isDisplayed(), "кнопка войти отсутствует, выйти из профиля не удалось");
    }
}
