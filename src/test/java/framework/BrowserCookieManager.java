package framework;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.Set;

public class BrowserCookieManager {
    private static Logger logger = Logger.getInstance();
    private static RemoteWebDriver remoteWebDriver = BrowserManager.getBrowser().getDriver();

    public static void addCookie(String name, String value) {
        logger.info(String.format("add cookie with name: %s value: %s", name, value));
        remoteWebDriver.manage().addCookie(new Cookie(name, value));
    }

    public static void addCookie(Cookie cookie) {
        logger.info(String.format("delete cookie with name: %s", cookie.getName()));
        remoteWebDriver.manage().addCookie(cookie);
    }

    public static void addCookies(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            addCookie(cookie);
        }
    }

    public static void deleteCookie(Cookie cookie) {
        logger.info(String.format("delete cookie with name: %s", cookie.getName()));
        remoteWebDriver.manage().deleteCookie(cookie);
    }

    public static Set<Cookie> getAllCookies() {
        logger.info("take all cookies");
        return remoteWebDriver.manage().getCookies();
    }

    public static Cookie getCookieByName(String name) {
        logger.info(String.format("get cookie with name: %s", name));
        return remoteWebDriver.manage().getCookieNamed(name);
    }

    public static void deleteAllCookies() {
        logger.info("delete all cookies");
        remoteWebDriver.manage().deleteAllCookies();
    }
}
