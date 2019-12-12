package framework;

import aquality.selenium.browser.AlertActions;
import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Alert {

    public  static RemoteWebDriver getDriver() {
        return BrowserManager.getBrowser().getDriver();
    }

    public  static String getTextOfAlert() {
        Logger.getInstance().info("take text of the alert");
        return getDriver().switchTo().alert().getText();
    }

    public  static void acceptAlert() {
        Logger.getInstance().info("Accept the alert");
        BrowserManager.getBrowser().handleAlert(AlertActions.ACCEPT);
    }

    public static void writeTextToFieldOfAlert(String text) {
        getDriver().switchTo().alert().sendKeys(text);
    }

    public  static void sendTextToAlert(String text) {
        Logger.getInstance().info("send text to the alert");
        writeTextToFieldOfAlert(text);
        acceptAlert();
    }
}
