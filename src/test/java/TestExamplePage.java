import aquality.selenium.browser.BrowserManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import pageobject.MainPage;
import java.util.Set;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class TestExamplePage {

    @Test
    public void testCookies() {
        PropertyConfigurator.configure("log4j.properties");
        BrowserManager.getBrowser().maximize();
        BrowserManager.getBrowser().goTo("http://example.com/");
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.isThisExampleMainPage());
        BrowserManager.getBrowser().getDriver().manage().addCookie(new Cookie("example_key_1", "example_value_1"));
        BrowserManager.getBrowser().getDriver().manage().addCookie(new Cookie("example_key_2", "example_value_2"));
        BrowserManager.getBrowser().getDriver().manage().addCookie(new Cookie("example_key_3", "example_value_3"));
        assertTrue(checkAllCookies(BrowserManager.getBrowser().getDriver().manage().getCookies()));
        BrowserManager.getBrowser().getDriver().manage().deleteCookieNamed("example_key_1");
        assertNull(BrowserManager.getBrowser().getDriver().manage().getCookieNamed("example_key_1"), "cookie not deleted");
        BrowserManager.getBrowser().getDriver().manage().deleteCookieNamed("example_key_3");
        BrowserManager.getBrowser().getDriver().manage().addCookie(new Cookie("example_key_3", "example_value_300"));
        assertEquals(BrowserManager.getBrowser().getDriver().manage()
                .getCookieNamed("example_key_3").getValue(), "example_value_300", "Cookie not changed");
        BrowserManager.getBrowser().getDriver().manage().deleteAllCookies();
        assertEquals(BrowserManager.getBrowser().getDriver().manage().getCookies().size(), 0, "Cookies is here");
        BrowserManager.getBrowser().quit();
    }

    public static boolean checkAllCookies(Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            if (!(cookie.getName().equals("example_key_1") & cookie.getValue().equals("example_value_1")
                    | cookie.getName().equals("example_key_2") & cookie.getValue().equals("example_value_2")
                    | cookie.getName().equals("example_key_3") & cookie.getValue().equals("example_value_3"))) {
                return false;
            }
        }
        return true;
    }
}
