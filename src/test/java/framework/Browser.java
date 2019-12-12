package framework;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Browser {
    public static void addCookie(String name, String value) {
        Logger.getInstance().info(String.format("add cookie with name: %s", name));
        BrowserManager.getBrowser().getDriver().manage().addCookie(new Cookie(name, value));
    }

    public static void addCookie(Cookie cookie) {
        Logger.getInstance().info(String.format("add cookie with name: %s", cookie.getName()));
        BrowserManager.getBrowser().getDriver().manage().addCookie(cookie);
    }

    public static void deleteCookie(Cookie cookie) {
        Logger.getInstance().info(String.format("delete cookie with name: %s", cookie.getName()));
        BrowserManager.getBrowser().getDriver().manage().deleteCookie(cookie);
    }

    public static Set<Cookie> getAllCookies() {
        Logger.getInstance().info("get all cookies");
        return BrowserManager.getBrowser().getDriver().manage().getCookies();
    }

    public static Cookie getCookieByName(String name) {
        Logger.getInstance().info(String.format("get cookie by name: %s", name));
        return BrowserManager.getBrowser().getDriver().manage().getCookieNamed(name);
    }

    public static void deleteAllCookies() {
        Logger.getInstance().info("delete all cookies");
        BrowserManager.getBrowser().getDriver().manage().deleteAllCookies();
    }
}
