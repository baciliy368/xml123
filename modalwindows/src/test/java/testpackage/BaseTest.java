package testpackage;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import framework.utils.PropertiesReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected Logger logger = Logger.getInstance();

    @BeforeTest
    public void beforeTest() {
        BrowserManager.getBrowser().maximize();
        BrowserManager.getBrowser().goTo(PropertiesReader.getValue("START_PAGE_JS_ALERT"));
    }

    @AfterTest
    public void afterTest() {
        BrowserManager.getBrowser().quit();
    }
}
