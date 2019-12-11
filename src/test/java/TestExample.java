import aquality.selenium.browser.Browser;
import aquality.selenium.browser.BrowserManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import pageobject.MainPage;

import java.util.Set;

public class TestExample {

    @Test
    public void test() {
        Browser browser = BrowserManager.getBrowser();
        browser.maximize();
        browser.goTo("http://example.com/");
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isThisPage());
        browser.getDriver().manage().addCookie(new Cookie("example_key_1", "example_value_1"));
        browser.getDriver().manage().addCookie(new Cookie("example_key_2", "example_value_2"));
        browser.getDriver().manage().addCookie(new Cookie("example_key_3", "example_value_3"));
        System.out.println(browser.getDriver().manage().getCookies().size());
        Assert.assertTrue(checkAllCookies(browser.getDriver().manage().getCookies()));
        browser.getDriver().manage().deleteCookieNamed("example_key_1");
        Assert.assertNull(browser.getDriver().manage().getCookieNamed("example_key_1"), "cookie not deleted");
        browser.getDriver().manage().deleteCookieNamed("example_key_3");
        browser.getDriver().manage().addCookie(new Cookie("example_key_3", "example_value_300"));
        Assert.assertEquals(browser.getDriver().manage().getCookieNamed("example_key_3").getValue(), "example_value_300", "Cookie not changed");
        browser.getDriver().manage().deleteAllCookies();
        Assert.assertEquals(browser.getDriver().manage().getCookies().size(), 0, "Cookies is here");
        browser.quit();
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
