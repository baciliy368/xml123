package testpackage;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import framework.BrowserCookieManager;
import framework.utils.PropertiesReader;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject.MainPage;
import java.util.Set;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class TestCookiesOperations extends BaseTest {
    Cookie exampleCookie1 = new Cookie("example_key_1", "example_value_1");
    Cookie exampleCookie2 = new Cookie("example_key_2", "example_value_2");
    Cookie exampleCookie3 = new Cookie("example_key_3", "example_value_3");
    Cookie[] arrCookiesExample = new Cookie[]{exampleCookie1, exampleCookie2, exampleCookie3};

    @Test
    public void testCookies() {
        logger.info("Step 1:");
        BrowserManager.getBrowser().goTo(PropertiesReader.getValue("START_EXAMPLE_PAGE"));
        logger.info("create mainPage");
        MainPage mainPage = new MainPage();
        logger.info("check is mainPage displayed");
        assertTrue(mainPage.isFormDisplayed());

        logger.info("Step: 2");
        BrowserCookieManager.addCookies(arrCookiesExample);
        logger.info("create softAssert");
        SoftAssert softAssert = new SoftAssert();
        Set<Cookie> allCookiesFromBrowser = BrowserCookieManager.getAllCookies();
        for (Cookie cookie : arrCookiesExample) {
            Logger.getInstance().info(String.format("check browser cookie %s", cookie.getName()));
            softAssert.assertTrue(allCookiesFromBrowser.contains(cookie));
        }
        softAssert.assertAll("Cookies is not added");

        logger.info("Step: 3");
        BrowserCookieManager.deleteCookie(exampleCookie1);
        logger.info("check: Is cookie deleted");
        assertNull(BrowserCookieManager.getCookieByName(exampleCookie1.getName()), "cookie is not deleted");

        logger.info("Step: 4");
        BrowserCookieManager.deleteCookie(exampleCookie3);
        BrowserCookieManager.addCookie(exampleCookie3.getName(), "example_value_300");
        logger.info("check: Is cookie changed");
        assertEquals(BrowserCookieManager.getCookieByName("example_key_3").getValue(), "example_value_300", "Cookie not changed");

        logger.info("Step: 5");
        BrowserCookieManager.deleteAllCookies();
        logger.info("check: Is cookies deleted");
        assertEquals(BrowserCookieManager.getAllCookies().size(), 0, "Cookies is not deleted");
    }


}
