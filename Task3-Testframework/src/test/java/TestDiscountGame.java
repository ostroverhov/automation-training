import app.pages.*;
import framework.browser.BrowserFactory;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestDiscountGame {
    String URL = Reader.getParametr("URL");
    int timeout = Integer.parseInt(Reader.getParametr("timeout"));

    @BeforeMethod
    public void setUp() {
        MyLogger.step("Старт теста");
        Wait.setImplicityWait(timeout);
        BrowserFactory.setMaxSizeWindow();
        BrowserFactory.setURL(URL);
        Directories.cleanDirectory(Reader.getParametr("path"));
    }

    @AfterMethod
    public void tearDown() {
        MyLogger.step("Окончание теста");
        BrowserFactory.closeBrowser();
    }

    @Test
    @Parameters(value = {"genreGame", "selectDiscount"})
    public void testHighestDiscountcheck(String genreGame, String selectDiscount) {
        MyLogger.step("Открытие и проверка главной страницы");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.header.isDisplayedButtonInstall(), "главная страница не открылась");
        MyLogger.step("Переход на страницу Экшен");
        mainPage.topMenu.navigateToTabMenu(Locales.getParametr("Games"));
        mainPage.topMenu.clickToDropDownMenuItem(Locales.getParametr(genreGame));
        GenrePage genrePage = new GenrePage();
        MyLogger.step("Проверка страницы Экшен");
        Assert.assertTrue(genrePage.headPanel.getPanelNameText().contains(mainPage.topMenu.getNameDropDownMenuItem()), "страница экшен не отрылась");
        MyLogger.step("Переход на вкладку лидеры продаж");
        genrePage.tabsMenu.clickToTabTopSeller();
        MyLogger.step("Проверка открытия вкладки лидеры продаж");
        Assert.assertTrue(genrePage.tabsMenu.isDisplayedTabTopSeller(), "Вкладка лидеры продаж не открылась");
        genrePage.tabsMenu.selectMaxMinDiscount(selectDiscount);
        genrePage.tabsMenu.clickGame();
        MyLogger.step("Переход на страницу проверки возраста при необходимости и ввод валидного возраста");
        ValidateBirthdayPage.inputAge();
        GamePage gamePage = new GamePage();
        MyLogger.step("Открытие страницы игры и проверка названия, скидки и цен");
        Assert.assertTrue(gamePage.headPanelGamePage.getName().contains(genrePage.tabsMenu.getName()), "названия не равны");
        Assert.assertEquals(genrePage.tabsMenu.getDiscount(), gamePage.headPanelGamePage.getDiscount(), "скидка не соответствует");
        Assert.assertEquals(genrePage.tabsMenu.getInitialPrice(), gamePage.headPanelGamePage.getInitialPrice(), "начальная цена не соответствует");
        Assert.assertEquals(genrePage.tabsMenu.getDiscountPrice(), gamePage.headPanelGamePage.getDiscountPrice(), "цена после скидки не соответствует");
    }
}
