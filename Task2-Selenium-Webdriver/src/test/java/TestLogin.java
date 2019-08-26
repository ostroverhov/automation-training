import application.*;
import browser.Browser;
import browser.BrowserSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestLogin {

    WebDriver driver = BrowserSingleton.getInstance("chrome");
    String URL = "https://market.yandex.by/";
    String login = "pupk1n.volodim1r";
    String password = "QWE123QWE";
    int timeout = 10;

    @BeforeMethod
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

//    @AfterMethod
//    public void tearDown(){
//        driver.close();
//    }

    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getMainPageLogoText(), "Маркет", "на странице не соответствует название логотипа, не верная страница");
        mainPage.clickButtonLogin();
        Browser.switchTab(driver);
        InputLoginPage inputLoginPage = new InputLoginPage(driver);
        inputLoginPage.setLogin(login);
        InputPasswordPage inputPasswordPage = new InputPasswordPage(driver);
        inputPasswordPage.setPassword(password);
        MainPageLogin mainPageLogin = new MainPageLogin(driver);
        Assert.assertTrue(mainPageLogin.getLogoUser(), "регистрация не прошла");
    }

    @Test
    public void testMenu(){
        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.getArrayCatalog();
    }
}
