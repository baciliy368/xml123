package framework;

import aquality.selenium.browser.AlertActions;
import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserAlertManager {
    private static Logger logger = Logger.getInstance();
    private static RemoteWebDriver driver = BrowserManager.getBrowser().getDriver();

    public  static String getTextOfAlert() {
        logger.info("take text of the alert");
        return driver.switchTo().alert().getText();
    }

    public  static void acceptAlert() {
        logger.info("Accept the alert");
        BrowserManager.getBrowser().handleAlert(AlertActions.ACCEPT);
    }

    public  static void sendTextToAlert(String text) {
        logger.info("send text to the alert");
        writeTextToFieldOfAlert(text);
        acceptAlert();
    }

    private static void writeTextToFieldOfAlert(String text) {
        logger.info(String.format("put text: %s to field of alert", text));
        driver.switchTo().alert().sendKeys(text);
    }
}
