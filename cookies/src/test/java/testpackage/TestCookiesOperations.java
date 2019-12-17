package testpackage;

import aquality.selenium.browser.BrowserManager;
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
        logger.info("Step 1: Open main page test");
        BrowserManager.getBrowser().goTo(PropertiesReader.getValue("START_EXAMPLE_PAGE"));
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.isFormDisplayed(), "main page is not displayed");

        logger.info("Step2: add cookies added");
        BrowserCookieManager.addCookies(arrCookiesExample);
        SoftAssert softAssert = new SoftAssert();
        Set<Cookie> allCookiesFromBrowser = BrowserCookieManager.getAllCookies();
        for (Cookie cookie : arrCookiesExample) {
            softAssert.assertTrue(allCookiesFromBrowser.contains(cookie));
        }
        softAssert.assertAll("Cookies is not added");

        logger.info("Step3: delete example_key_1 cookie");
        BrowserCookieManager.deleteCookie(exampleCookie1);
        assertNull(BrowserCookieManager.getCookieByName(exampleCookie1.getName()), "cookie is not deleted");

        logger.info("Step4: edit example_key_3 cookie");
        BrowserCookieManager.deleteCookie(exampleCookie3);
        BrowserCookieManager.addCookie(exampleCookie3.getName(), "example_value_300");
        assertEquals("example_value_300", BrowserCookieManager.getCookieByName("example_key_3").getValue(), "Cookie is not changed");

        logger.info("Step5: delete all cookies");
        BrowserCookieManager.deleteAllCookies();
        assertEquals(0, BrowserCookieManager.getAllCookies().size(), "Cookies are not deleted");
    }
}
