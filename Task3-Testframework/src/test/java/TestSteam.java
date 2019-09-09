import app.pages.*;
import framework.browser.Browser;
import framework.browser.BrowserFactory;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;


public class TestSteam extends CommonConditions {

    @Test
    public void testSteamInstall() {
        MyLogger.step("Open and check main page");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.getHeader().isDisplayedButtonInstall(), "main page not found");

        MyLogger.step("Go to download page");
        mainPage.getHeader().clickOnButtonInstall();
        InstallPage installPage = new InstallPage();
        Assert.assertTrue(installPage.isDisplayedButtonInstall(), "download page not found");

        MyLogger.step("Download file");
        installPage.clickButtonInstall();
        File downloadFile = new File(Reader.getNameDownloadFile());
        Wait.waitForFile(downloadFile);

        MyLogger.step("Check file in system");
        Assert.assertTrue(downloadFile.isFile(), "file not found");
    }
}
