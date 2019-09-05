package framework.browser;

import framework.utils.Reader;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;


public class BrowserSettings {

    public static DesiredCapabilities chromeSettings() {
        String pathToDownload = Reader.getParametr("path");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "/" + pathToDownload);
        chromePrefs.put("safebrowsing.enabled", "true");
        chromePrefs.put("intl.accept_languages", Reader.getParametr("locale"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        return cap;
    }

    public static FirefoxOptions firefoxSettings() {
        String pathToDownload = Reader.getParametr("path");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("browser.download.dir", System.getProperty("user.dir") + "/" + pathToDownload);
        firefoxOptions.addPreference("browser.download.folderList", 2);
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream, application/x-debian-package");
        firefoxOptions.addPreference("intl.accept_languages", Reader.getParametr("locale"));
        return firefoxOptions;
    }
}
