import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import framework.Browser;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject.MainPage;
import java.util.Set;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class TestCookiesOperations {
    Cookie exampleCookie1 = new Cookie("example_key_1", "example_value_1");
    Cookie exampleCookie2 = new Cookie("example_key_2", "example_value_2");
    Cookie exampleCookie3 = new Cookie("example_key_3", "example_value_3");
    Cookie[] arrCookiesExample = new Cookie[]{exampleCookie1, exampleCookie2, exampleCookie3};

    @BeforeTest
    public void beforeTest() {
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
        BrowserManager.getBrowser().maximize();
        BrowserManager.getBrowser().goTo("http://example.com/");
    }

    @Test
    public void testCookies() {
        MainPage mainPage = new MainPage();
        Logger.getInstance().info("check is mainPage displayed");
        assertTrue(mainPage.isFormDisplayed());
        for (Cookie cookie : arrCookiesExample) {
            Browser.addCookie(cookie);
        }
        SoftAssert softAssert = new SoftAssert();
        Set<Cookie> allCookiesFromBrowser = Browser.getAllCookies();
        if (allCookiesFromBrowser.size() == arrCookiesExample.length) {
            for (Cookie cookie : arrCookiesExample) {
                Logger.getInstance().info(String.format("check browser cookie %s", cookie.getName()));
                softAssert.assertTrue(allCookiesFromBrowser.contains(cookie));
            }
        }
        softAssert.assertAll("Cookies is not added");
        Browser.deleteCookie(exampleCookie1);
        assertNull(Browser.getCookieByName(exampleCookie1.getName()), "cookie is not deleted");
        Browser.deleteCookie(exampleCookie3);
        Browser.addCookie(exampleCookie3.getName(), "example_value_300");
        assertEquals(Browser.getCookieByName("example_key_3").getValue(), "example_value_300", "Cookie not changed");
        Browser.deleteAllCookies();
        assertEquals(Browser.getAllCookies().size(), 0, "Cookies is not deleted");
    }

    @AfterTest
    public void afterTest() {
        BrowserManager.getBrowser().quit();
    }
}
