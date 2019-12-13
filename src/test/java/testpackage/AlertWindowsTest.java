package testpackage;

import framework.BrowserAlertManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pajeobject.JavaScriptAlertPage;

public class AlertWindowsTest extends BaseTest {
    private int numberOfRandomSymbols = 10;

    @Test
    public void jsAlertTest() {
        logger.info("Step 1:");
        logger.info("Create javaScriptAlertPage");
        JavaScriptAlertPage javaScriptAlertPage = new JavaScriptAlertPage();
        javaScriptAlertPage.getAlertsMenu().clickJs("jsAlert()");
        logger.info("check text of alert");
        Assert.assertEquals(BrowserAlertManager.getTextOfAlert(), "I am a JS Alert", "alert fail");

        logger.info("Step 2:");
        BrowserAlertManager.acceptAlert();
        logger.info("check result of accepting of alert");
        Assert.assertEquals(javaScriptAlertPage.getTextOfResult(), "You successfuly clicked an alert",
                "result us not correct");

        logger.info("Step 3:");
        javaScriptAlertPage.getAlertsMenu().clickJs("jsConfirm()");
        logger.info("check text of alert");
        Assert.assertEquals(BrowserAlertManager.getTextOfAlert(), "I am a JS Confirm", "alertConfirm fail");

        logger.info("Step 4:");
        BrowserAlertManager.acceptAlert();
        logger.info("check text of result");
        Assert.assertEquals(javaScriptAlertPage.getTextOfResult(), "You clicked: Ok",
                "result us not correct");

        logger.info("Step 5:");
        javaScriptAlertPage.getAlertsMenu().clickJs("jsPrompt()");
        logger.info("check text of alert");
        Assert.assertEquals(BrowserAlertManager.getTextOfAlert(), "I am a JS prompt", "alertPrompt fail");

        logger.info("Step 6:");
        logger.info("Generate Random String");
        String randomStingForPromptAlert = RandomStringUtils.randomAlphabetic(numberOfRandomSymbols);
        BrowserAlertManager.sendTextToAlert(randomStingForPromptAlert);
        logger.info("check text of result");
        Assert.assertEquals(javaScriptAlertPage.getTextOfResult(), String.format("You entered: %s", randomStingForPromptAlert),
                "result us not correct");
    }
}
