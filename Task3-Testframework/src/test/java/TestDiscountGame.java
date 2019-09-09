import app.Game;
import app.pages.*;
import framework.browser.Browser;
import framework.browser.BrowserFactory;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestDiscountGame extends CommonConditions {

    @Test
    @Parameters(value = {"genreGame", "selectDiscount", "year"})
    public void testHighestDiscountcheck(String genreGame, String selectDiscount, int year) {
        MyLogger.step("Open and check main page");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.getHeader().isDisplayedButtonInstall(), "main page not found");

        MyLogger.step("Go to page action");
        mainPage.getTopMenu().navigateToTabMenu(Locales.getParametr("Games"));
        String nameDropDownMenuItem = Locales.getParametr(genreGame);
        mainPage.getTopMenu().clickToDropDownMenuItem(nameDropDownMenuItem);
        GenrePage genrePage = new GenrePage();

        MyLogger.step("Check page action");
        Assert.assertTrue(genrePage.getHeadPanel().getPanelNameText().contains(nameDropDownMenuItem), "page action not found");

        MyLogger.step("Go to tab topseller");
        genrePage.getTabsMenu().clickToTabTopSeller();

        MyLogger.step("Check tab topseller");
        Assert.assertTrue(genrePage.getTabsMenu().isDisplayedTabTopSeller(), "Tab topseller not found");
        Game gameWithDiscount = null;
        gameWithDiscount = genrePage.getTabsMenu().getGameDiscountFromTopSellerTab(selectDiscount);
        genrePage.getTabsMenu().clickGame();

        MyLogger.step("Go to page validation age and input valid age");
        ValidateBirthdayPage.inputAge(year);
        GamePage gamePage = new GamePage();

        MyLogger.step("Open page with game and check name, discount and prices");
        Assert.assertTrue(gamePage.getHeadPanelGamePage().getName().contains(gameWithDiscount.getNameGame()), "names not equals");
        Assert.assertEquals(gamePage.getHeadPanelGamePage().getDiscount(), gameWithDiscount.getDiscountRate(), "discounts not equals");
        Assert.assertEquals(gamePage.getHeadPanelGamePage().getInitialPrice(), gameWithDiscount.getInitialPrice(), "initial prices not equals");
        Assert.assertEquals(gamePage.getHeadPanelGamePage().getDiscountPrice(), gameWithDiscount.getDiscountPrice(), "discounted prices not equals");
    }
}
