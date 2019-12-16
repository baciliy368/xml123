package framework;

import aquality.selenium.browser.AlertActions;
import aquality.selenium.browser.BrowserManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserAlertManager {
    private static RemoteWebDriver driver = BrowserManager.getBrowser().getDriver();

    public  static String getTextOfAlert() {
        return driver.switchTo().alert().getText();
    }

    public  static void acceptAlert() {
        BrowserManager.getBrowser().handleAlert(AlertActions.ACCEPT);
    }

    public  static void sendTextToAlert(String text) {
        writeTextToFieldOfAlert(text);
        acceptAlert();
    }

    private static void writeTextToFieldOfAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}
