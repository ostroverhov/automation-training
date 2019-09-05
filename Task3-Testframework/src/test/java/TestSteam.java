import app.pages.*;
import framework.browser.BrowserFactory;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;


public class TestSteam {

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
    public void testSteamInstall() {
        MyLogger.step("Открытие и проверка главной страницы");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.header.isDisplayedButtonInstall(), "главная страница не открылась");
        MyLogger.step("Переход на страницу установки");
        mainPage.header.clickOnButtonInstall();
        InstallPage installPage = new InstallPage();
        MyLogger.step("Проверка открытия страницы установки");
        Assert.assertTrue(installPage.isDisplayedButtonInstall(), "страница установки не открылась");
        MyLogger.step("Скачивание установочного файла");
        installPage.clickButtonInstall();
        File downloadFile = new File(Reader.getNameDownloadFile());
        Wait.waitForFile(downloadFile);
        MyLogger.step("Проверка наличия файла в файловой системе");
        Assert.assertTrue(downloadFile.isFile(), "файл не найден");
    }
}
